package campos;

public class CampoNumero implements Validable {

	@Override
	public boolean isValid(String texto) {
        for (char ch : texto.toCharArray()) {
			if (!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}
}
