# Smartbids (backend)

Implemented backend for smarbids application according to clean/hexagonal architecture adhering domain driven design. 
Sub domains in smartbids do following operations

1. User 
  - Allow user registration
2. Item
  - Publish items for auctions
  - Allow selecting a bid for a published item and emit a domain event
3. Bid
  - Allow bidding for published auction items
4. Notifications
  - Listen to domain events which needs to be sent to users through email or sms
5. Commons
  - Handle cross cutting concerns like security etc.
  
# Further Improvements
  Add WebSocket support to get real time updates to auctioneer about added bids

# Used Technologies

- Used Architectural patterns/designs: Domain Driven Design (DDD), Clean Architecture (keep options open), Hexagonal, Port and Adapters 
- Used technologies (under infrastructure) : Spring boot (ioc), Spring data (JPA), Rest, AMQP (Rabbit MQ), MySQL, spring security (application managed JWT authentication and authorization)
- CI/CD : Docker, Kubernetes

# Few screen shots added from client application developed using Angular

![image](https://user-images.githubusercontent.com/5676375/130425561-c3038971-a3f6-4936-8706-614b0a4b4ab4.png)

![image](https://user-images.githubusercontent.com/5676375/130425967-72ee5081-7f4a-4294-9d0b-f15cc2674eca.png)

![image](https://user-images.githubusercontent.com/5676375/130426123-b0af6721-62d8-414a-ba21-92928b6e0d58.png)



# Note : Unit tests, component tests and integration tests to be written
