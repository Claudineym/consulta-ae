/**
 * 
 */
package br.gov.fazenda.mg.enumerator;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author marcos.fernando
 *
 */

public enum TipoGrupoImposto {

	@XStreamAlias(value = "ICMS00")
	ICMS00("ICMS00"), 
	ICMS20("ICMS20"), ICMS40("ICMS40"), ICMS45("ICMS45"), 
	@XStreamAlias(value = "ICMS51")	
	ICMS51("ICMS51"), 
	ICMS60("ICMS60"), ICMS90("ICMS90"), ICMSOUTRAUF("ICMSOutraUF"), ICMSSN("ICMSSN"),	
	ICMSSN102("ICMSSN102"), ICMSSN900("ICMSSN900"), PISALIQ("PISAliq"), PISQTDE("PISQtde"), 
	PISNT("PISNT"), PISSN("PISSN"),	PISOUTR("PISOutr"), PISST("PISST"), COFINSALIQ("COFINSAliq"), 
	COFINSQTDE("COFINSQtde"), COFINSNT("COFINSNT"), COFINSSN("COFINSSN"), 
	COFINSOUTR("COFINSOutr"), COFINSST("COFINSST");

	private final String descricao;

	TipoGrupoImposto(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
