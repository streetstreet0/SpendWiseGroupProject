package backend;

public enum TransactionCategory {
	NONE,
	NEED,
	WANT,
	LUXURY;
	
	@Override
	public String toString() {
		String name = this.name().charAt(0) + this.name().substring(1).toLowerCase();
		return name;
	}
	
	public static TransactionCategory toCategory(String string) {
		if (string.equals(NEED.name())) {
			return NEED;
		}
		else if (string.equals(WANT.name())) {
			return WANT;
		}
		else if (string.equals(LUXURY.name())) {
			return LUXURY;
		}
		else {
			return NONE;
		}
	}
}


