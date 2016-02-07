package lesson13.lambda.tax;

@FunctionalInterface
public interface TaxFunction {
	double calcTax(double grossIncome);
}
