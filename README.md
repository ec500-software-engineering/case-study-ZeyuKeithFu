# Mastodon Case Study
[Mastodon](https://github.com/tootsuite/mastodon) is a decentralized social network with no ads and no corporate surveillance. 

## User Behaviors
### Basic concepts   
* **User and instance**   
Mastodon is a federated social network. Every server is called an ```instance```, which can hold a group of users and share a same set of rules. An ```user``` can only be in one specific instance, meanwhile, the user will also be in the whole ```Mastodon universe``` and interact with other users in the universe. Every instance will have its own code of conduct and users can select their favorite instance to join.   
* **Toot**   
A toot is similar to a "tweet" in Twitter, which is the content post by an user.
* **timeline**  
A timeline is a list of ```toots```. There are three forms of timeline, homepage timeline, local timeline and federated timeline. A ```homepage timeline``` contains all the toots post by your following users. A ```local timeline``` contains all the toots post by users in your ```instance```, ignoring following or not. A ```federated timeline``` contains all the toots post in the whole Mastodon universe. Note that, any timeline strictly sorting by posting time.
   
**In practical terms**: A ```Mastodon universe``` is the whole universe of social networks including Twitter, Facebook, Instagram etc., an ```instance``` is a specific social network, say Twitter for example. In Mastodon, an ```user``` in Twitter is also an user in the whole universe and can interact with users in Facebook or Instagram,  for example, a Twitter user can follow a Facebook user and see the content post by an Instagram user.
### Signing in and posting   
An user **MUST** sign in at a specific instance. However, users do not specify instance when posting. In other words, although an user stays on only one planet, he/she is posting to the whole universe. Here is a list of [existing instances](https://joinmastodon.org/).   
### Addressing / Following people   
Mastodon usernames consist of two parts. An example can be ```@aznable@cmx.im``` including:
* A ```local username``` (@aznable)   
* A ```domain of the server``` (@cmx.im)  
   
When addressing or following another user, both of these have to be specified.   
   
   
## Decentralization
In traditional centralized social networks such as Twitter, Facebook or Instagram, a central node is used by all users. Unlike these social networks, Mastodon has multiple nodes that any numbers of users can use. Meanwhile, all the nodes are connected so that they can interact with each other. Decentralization gives Mastodon some good features that other social networks will never have:
* **No ads**   
Mastodon is open source social network, which allows people to create their own site and make their own rules. Even a small group of close friends can create a new Mastodon site for playing. That is to say, Mastodon is not owned by one big corporation and no one will track your information and sell to advertisers. You would never see ads recommended by system appearing on your homepage.   
* **Cannot be blocked**   
Even though a Mastodon user only join one instance, all the contents from other sites can be viewed. When one instance is blocked, you can just switch to another instance and you can still browse all the contents. Even though all the existing instances are blocked (in a very very small probability), you can still open a new instance and the contents in Mastodon universe are still there.   

## CI Test

## Interesting Functions
### Exporting and importing data and change to another instance   
### Voting Toots   
### Direct message to users from other instances

## APIs
Mastodon provide [APIs](https://docs.joinmastodon.org/api/libraries/) for various of programming languages. In this part I tested Mastodon python API which can be installed by:   
```
pip install Mastodon.py
```
In ```test_API.py```, I posted a toot to my Mastodon account using the API.
   
![](https://github.com/ec500-software-engineering/case-study-ZeyuKeithFu/blob/master/assets/first_toot.png)
