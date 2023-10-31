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
}


