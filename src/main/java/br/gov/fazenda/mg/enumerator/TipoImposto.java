/**
 * 
 */
package br.gov.fazenda.mg.enumerator;

/**
 * @author marcos.fernando
 *
 */
public enum TipoImposto {

	ICMS("ICMS"), PIS("PIS"), PISST("PISST"), COFINS("COFINS"), COFINSST(
			"COFINSST"), ISSQN("ISSQN");

	private final String descricao;

	TipoImposto(String descricao) {
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
