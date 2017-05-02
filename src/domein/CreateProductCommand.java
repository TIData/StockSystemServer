package domein;

public class CreateProductCommand implements Command {

    private final StockService stockService;
    private final String productName;
    private final int quantity;

    public CreateProductCommand(String productName, int quantity, StockService stockService) {
        this.productName = productName;
        this.quantity = quantity;
        this.stockService = stockService;
    }

    @Override
    public String execute() {
        return stockService.insert(productName, quantity);
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
}
