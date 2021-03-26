class SearchResults {
    Collection<Car> cars;

    Iterator<Car> get Iterator();

    SearchResults filterByPrice(maxPrice)
    SearchResults filterByYear(earliestYear)
    SearchResults filterByMake(make)
    SearchResults filterByModel(model)
    SearchResults filterByColor(color)
}

class CarDealer {
    Collection<Car> cars;
    SearchResults search();
}

CarDealer dealer;
...
SearchResults results = 
    dealer.search().filterByPrice(3000).filterByColor("Blue");
for (Car car : results) 
    System.out.println(car)

