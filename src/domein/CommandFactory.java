package domein;

public class CommandFactory {

    public static Command createCommand(String[] arguments,
            StockService stockService) {
        try {
            switch (arguments[0].toLowerCase()) {
                case "updatequantity":
                    return new UpdateQuantityCommand(
                            arguments[1], Integer.parseInt(arguments[2]), stockService);
                case "shipproduct":
                    return new ShipProductCommand(arguments[1], stockService);
                case "createproduct":
                    return new CreateProductCommand(arguments[1],
                            Integer.parseInt(arguments[2]), stockService);
                case "showstock":
                    return new ShowStockCommand(stockService);
            }
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            return new NoCommand(arguments.length > 0 ? String.format("%s called with invalid arguments", arguments[0]) : "No command arguments provided");
        }

        return new NoCommand(arguments[0]);
    }
}
