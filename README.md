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


# To run locally in a kubernets cluster (minikube) - Set up minukube locally
1. Install minikube
2. Run following command in power shell (administrator)
 $oldpath=[Environment]::GetEnvironmentVariable("Path", [EnvironmentVariableTarget]::Machine) if($oldpath -notlike "*;C:\minikube*"){`
[Environment]::SetEnvironmentVariable("Path", $oldpath+";C:\minikube", [EnvironmentVariableTarget]::Machine)`
3. minikube start

To verify installation

4. kubectl get po -A
5. kubectl create deployment hello-minikube --image=k8s.gcr.io/echoserver:1.4
6. kubectl expose deployment hello-minikube --type=NodePort --port=8080
7. kubectl get services hello-minikub
8. kubectl port-forward service/hello-minikube 7080:8080

- Run k8 configurations resides in \kuberntes folder

1. minikube docker-env | Invoke-Expression
2. docker build -t lmsamarawickrama/smartbids-backend .

3. kubectl apply -f .\mysql-configmap.yml
4. kubectl apply -f .\rabbitmq-configmap.yml
5. kubectl apply -f .\mysqldb-credentials.yml
6. kubectl apply -f .\rabbitmq-credentials.yml

7. kubectl apply -f .\db-deployment.yml
8. kubectl apply -f .\broker-deployment.yml
9. kubectl apply -f .\app-deployment.yml

- to access a service locally (get the url first)

10. minikube service smartbids-backend --url
11. minikube service smartbids-client-service --url

- Install ingress

12. kubectl apply -f .\app-ingress.yml
13. kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.0.0/deploy/static/provider/cloud/deploy.yaml
14. minikube addons enable ingress
15. minikube tunnel (perform invocations while tunneling in progress)
 
# Tips for truble shooting

- kubectl get pods
- kubectl describe pod smartbids-backend-7c78b7db46-kljfh
- kubectl logs smartbids-backend-7c78b7db46-kljfh > error.log

# Note : Unit tests, component tests and integration tests to be written
