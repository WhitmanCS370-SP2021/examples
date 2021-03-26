class SearchResults {
    Collection<Car> cars;

    Iterator<Car> get Iterator();

    void filterByPrice(maxPrice)
    void filterByYear(earliestYear)
    void filterByMake(make)
    void filterByModel(model)
    void filterByColor(color)
}

class CarDealer {
    Collection<Car> cars;
    SearchResults search();
}

CarDealer dealer;
...
SearchResults results = dealer.search();
results.filterByPrice(3000);
results.filterByColor("Blue");
for (Car car : results) 
    System.out.println(car)

