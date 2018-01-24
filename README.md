# Insurance application

Imagine a modular insurance product. People can choose from 4 modules. Each module has a different
selectable coverage and a different mathematical risk.
These are the modules:

- `--Bike` - (Coverage 0-3k, Risk 30%)
- `--Jewelry` - (Coverage 500-10k, Risk 5%)
- `--Electronics` - (Coverage 500-6k, Risk 35%)
- `--Sports Equipment` - (Coverage 0-20k, Risk 30%)

The user should be able to select the coverage for each module. The price of the tariff, which is the individual
configuration for each customer, should be calculated based on the risk.

The project uses docker, to build and run it you must be execute two commands: 
- `--Build project` - docker-compose build
- `--Start projects` - docker-compose up (Frontend start on address localhost:8080 and backend on port localhost:8081)

To understand more about the api access the url http://localhost:8081/swagger-ui.html. You can get more information there.

### Understand frontend


