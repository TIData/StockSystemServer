package domein;

public class ShipProductCommand implements Command {

    private final StockService stockService;
    private final String productName;

    public ShipProductCommand(String productName, StockService stockService) {
        this.productName = productName;
        this.stockService = stockService;
    }

    @Override
    public String execute() {
        return stockService.ship(productName);
    }
}
