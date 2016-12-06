package br.com.loureiro.scf.bean;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.loureiro.scf.constante.EnumStatus;
import br.com.loureiro.scf.constante.EnumTipoConta;
import br.com.loureiro.scf.modelo.MdlCRUD;
import br.com.loureiro.scf.vo.VoContas;
import br.com.loureiro.scf.vo.VoSaldo;

@ManagedBean
public class BeanSaldo {

	private static final Logger logger = LogManager.getLogger(BeanSaldo.class);
	
	private VoSaldo vo = new VoSaldo();
	
	private List<VoContas> lista;
	private List<VoContas> listaPagas;
	private List<VoContas> listaReceber;
	
	private Double somar = 0D;
	private Double somarPagar = 0D;
	private Double somarReceber = 0D;
	
	private int status = EnumStatus.INDEFINIDO.get();
	
	public void relatorio() {		
		try {			
			iniciandoVariaveis();
			verificaData();
			selecionarContasPagas();
			selecionarContasRecebidas();
			ordenarLista();
			calculandoTotal();			
			status = EnumStatus.SUCESSO.get();	
			vo = new VoSaldo();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			status = EnumStatus.ERROR.get();
		}
	}

	private void verificaData() {
		if(vo.getData1() == null && vo.getData2() == null) {
			LocalDate localDate = LocalDate.now().withMonth(vo.getMesReferencia());
			vo.setData1(localDate.withDayOfMonth(1));
			vo.setData2(localDate.withDayOfMonth(localDate.lengthOfMonth()));
		}
		
		logger.debug("Data1=" + vo.getData1() + " - " + "Data2=" + vo.getData2());		
	}
	
	private void iniciandoVariaveis() {
		logger.debug("iniciando variaveis");
		
		lista = new ArrayList<>();
		listaPagas = new ArrayList<>();
		listaReceber = new ArrayList<>();
	}
	
	private void selecionarContasPagas() throws Exception {	
		logger.debug("selecionando contas pagas");
		selecionar(listaPagas, EnumTipoConta.CONTA_PAGA);
		somarPagar = somar;
	}
	
	private void selecionarContasRecebidas() throws Exception {
		logger.debug("selecionando contas recebidas");
		selecionar(listaReceber, EnumTipoConta.CONTA_RECEBIDA);
		somarReceber = somar;
	}
	
	@SuppressWarnings("unchecked")
	private <T> void selecionar(List<T> mLista, EnumTipoConta mEnum) throws Exception {
		somar = 0D;
		new MdlCRUD().find(vo, mEnum, (rset) -> { 
			while(rset.next()) {
				mLista.add((T) new VoContas(rset.getInt(1), 
										    rset.getString(2), 
										    rset.getDouble(3), 
										    LocalDate.parse(rset.getDate(4).toString()), 
										    EnumTipoConta.getEnumTipoConta(rset.getInt(5))));
				somar += rset.getDouble(3);
			}
		});
		lista.addAll((Collection<? extends VoContas>) mLista);
	}

	private void ordenarLista() {		
		logger.debug("ordenando contas");
		
		lista.sort((VoContas o1, VoContas o2)->{
			Integer compare1 = o1.getTipoPagamento().compareTo(o2.getTipoPagamento());
			Integer compare2 = o1.getDataAsString().compareTo(o2.getDataAsString());
			return compare1.compareTo(compare2);
		});
	}
	
	private void calculandoTotal() {		
		logger.debug("calculando total\n");
		
		Double resultado = somarReceber - somarPagar;
		NumberFormat decimalFormat = new DecimalFormat("#.00");     
		resultado = Double.valueOf(decimalFormat.format(resultado).replaceAll(",", "."));
		lista.add(new VoContas(null, null, resultado, null, EnumTipoConta.TOTAL));
	}

	public VoSaldo getVo() {
		return vo;
	}
	
	public List<VoContas> getLista() {
		return lista;
	}

	public int getStatus() {
		return status;
	}
	
}