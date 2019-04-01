# Mastodon Case Study
[Mastodon](https://joinmastodon.org/) is a decentralized social network with no ads and no corporate surveillance. 

## Decentralization

## User Behaviors
### Basic concepts   
* **User and instance**   
**Mastodon** is a federated social network. Every server is called an ```instance```, which can hold a group of users and share a same set of rules. An ```user``` can only be in one specific instance, meanwhile, the user will also be in the whole ```Mastodon universe``` and interact with other users in the universe.   
* **Toot**   
A toot is similar to a "tweet" in Twitter, which is the content post by an user.
* **timeline**  
A timeline is a list of ```toots```. There are three forms of timeline, homepage timeline, local timeline and federated timeline. A ```homepage timeline``` contains all the toots post by your following users. A ```local timeline``` contains all the toots post by users in your ```instance```, ignoring following or not. A ```federated timeline``` contains all the toots post in the whole Mastodon universe.   
Note that, any timeline strictly sorting by posting time.
   
**In practical terms**: A ```Mastodon universe``` is the whole universe of social networks including Twitter, Facebook, Instagram etc., an ```instance``` is a specific social network, say Twitter for example. In Mastodon, an ```user``` in Twitter is also an user in the whole universe and can interact with users in Facebook or Instagram,  for example, a Twitter user can follow a Facebook user and see the content post by an Instagram user.
### Signing in and posting   
An user **MUST** sign in at a specific instance. However, users do not specify instance when posting. In other words, although an user stays on only one planet, he/she is posting to the whole universe.   
### Addressing / Following people   
Mastodon usernames consist of two parts. An example can be ```@aznable@cmx.im``` including:
* A ```local username``` (@aznable)   
* A ```domain of the server``` (@cmx.im)   
When addressing or following another user, both of these have to be specified.   
## Technology Selections

## APIs
