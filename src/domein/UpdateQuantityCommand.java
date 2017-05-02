package domein;

public class UpdateQuantityCommand implements Command {

    private final StockService stockService;
    private final String productName;
    private final int newQuantity;

    public UpdateQuantityCommand(String productName, int quantity, StockService stockService) {
        this.productName = productName;
        newQuantity = quantity;
        this.stockService = stockService;
    }

    @Override
    public String execute() {
        return stockService.update(productName, newQuantity);
    }

    public int getNewQuantity() {
        return newQuantity;
    }
}
