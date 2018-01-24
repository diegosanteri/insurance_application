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
- `--docker-compose build` - Build project
- `--docker-compose up` -  Start projects (Frontend start on address localhost:8080 and backend on port localhost:8081)

To understand more about the api access the url http://localhost:8081/swagger-ui.html. You can get more information there.

### Understand frontend

- `First screen`
![alt tag](https://cdn.rawgit.com/diegosanteri/insurance_application/6b678209/image/dashboard.png "Dashboard image")

- `Click in insurance in left side, after that you will see Management item. Click on it to see the scren`
![alt tag](https://cdn.rawgit.com/diegosanteri/insurance_application/6b678209/image/pending_simulations.png "Pending simulations")

- `To adding a new insurance click in new simulation tab and fill the fields, after click in create simulation`
![alt tag](https://cdn.rawgit.com/diegosanteri/insurance_application/6b678209/image/new_simulation.png "New simulation image")

- `You will be redirect to update page, you can access this page comming back to pending simulation tab and click in the orange button.`
![alt tag](https://cdn.rawgit.com/diegosanteri/insurance_application/6b678209/image/update_simulation.png "Update page")

- `After the update you will redirect to pending simulations page. There click in the red button to delete one simulation,
you will be redirect to delete simulation tab`
![alt tag](https://cdn.rawgit.com/diegosanteri/insurance_application/6b678209/image/delete_simulation.png "Delete simulation")

- `After the delete operation, you will be redirect to peding simulations. There click in the green button to purchase one insurance. You will be redirect to confirm purchase contract`
![alt tag](https://cdn.rawgit.com/diegosanteri/insurance_application/6b678209/image/purchase_insurance.png "Purchase insurance")

- - `After the delete operation, you will be redirect to peding simulations. To see you contract click in Purchased Insurance tab, you will see all purchased contracts.`
![alt tag](https://cdn.rawgit.com/diegosanteri/insurance_application/6b678209/image/purchased_insurance.png "Purchased insurance")
