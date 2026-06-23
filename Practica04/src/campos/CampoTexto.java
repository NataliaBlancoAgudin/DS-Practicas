package campos;

public class CampoTexto implements Validable {

	@Override
	public boolean isValid(String texto) {
		boolean valido = true;
		for (char ch : texto.toCharArray()) {
			if (!Character.isLetter(ch)) {
				valido = false;
				break;
			}
		}
		return valido;
	}
}
