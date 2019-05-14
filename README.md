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

## Technology Selection   
Mastodon is a **Ruby on Rails** application with a **React.js** front-end.
* ```Ruby on Rails``` powers the REST API and other web pages
* ```React.js``` and Redux are used for the dynamic parts of the interface
* ```Node.js``` powers the streaming API   
   
A standard Mastodon development environment requires ```Ruby```, ```Node.js```, ```PostgreSQL``` and ```Redis```.   
   
**Important libraries:**   
   
* **Ruby**
   + ```haml```, a templating language
   + ```devise```, for authentication
   + ```doorkeeper```, for acting as an OAuth 2 provider
   + ```paperclip```, for file uploads and attachments
   + ```sidekiq```, for background processing
* **JavaScript**
   + ```immutable```, for immutable data structures
   + ```react```, for rendering the dynamic web application
   + ```react-redux```, for managing React state
   + ```react-router-dom```, for navigation within React
   + ```react-intl```, for localizations within React
   
   
**Ruby Code Structure:**   
   
![](https://github.com/ec500-software-engineering/case-study-ZeyuKeithFu/blob/master/assets/Ruby_structure.png)
   
## CI Test
**10 checks on CircleCI including:**
* build
* check-i18n
* install
* install-ruby2.4
* install-ruby2.5
* install-ruby2.6
* test-ruby2.4
* test-ruby2.5
* test-ruby2.6
* test-webui


## Functionality Demo
Based on decentralization, some interesting features is built in Mastodon, which are not owned by other social network applications, including:
### 1. Change to another instance by exporting and importing user data
Sometimes you may want to explore new things and change to another Mastodon instance to stay (just like sometimes you want to use twitter but not facebook). To do this, you can simply export your user data before you change instance.   
   
![](https://github.com/ec500-software-engineering/case-study-ZeyuKeithFu/blob/master/assets/data_export.png)   
   
After you moved to a new instance and you want to recover all your settings and datas (your followings, your favorites, your pinned toots etc.,), you can import your ```.CSV``` format user data and everything will be same as before except you are now in another instance.   
   
![](https://github.com/ec500-software-engineering/case-study-ZeyuKeithFu/blob/master/assets/data_import.png)   
   
This action is like you are move from ```twitter``` to ```instagram``` but you are still following the users you used to follow and can still see your liked tweets. Obviously, these works cannot be done on neither twitter nor instagram.
   
### 2. Direct message to users from other instances   
Imaging that you are in a country that ```Line``` is popular used and you only use Line for social connections. A classmate of you is from a country that ```WhatsApp``` is popular used and he/she only use WhatsApp. What if you want to discuss about courseworks online? Either one of you change to the other social network or you both register for a third social network. In Mastodon, however, this work can be done really fast because direct messages can be created between users from different instances.   
   
![](https://github.com/ec500-software-engineering/case-study-ZeyuKeithFu/blob/master/assets/dm.png)   
   
(I received direct messages from my friends in different instances.)   
   
### 3. Chronological timeline
Nowadays most social networks use algorithmic timeline. That is why you often see celebrities' posts or ads shown above your real friends' posts. In Mastodon however, timeline strictly follows chronological rule. Latest post always shows first. Three kinds of timeline are included in Mastodon:
* ```Home timeline```, the timeline of your following users
* ```Local timeline```, the timeline of all the toots in your instance
* ```Federated timeline```, the timeline of toots from all Mastodon users
   

## API Demo
Mastodon provide [APIs](https://docs.joinmastodon.org/api/libraries/) for various of programming languages. In this part I tested Mastodon python API which can be installed by:   
```
pip install Mastodon.py
```
In ```test_API.py```, I posted a toot to my Mastodon account using the API.
   
![](https://github.com/ec500-software-engineering/case-study-ZeyuKeithFu/blob/master/assets/first_toot.png)
   
## Demo App
In this part I made a demo Android App by Mastodon Java API [mastodon4j](https://github.com/sys1yagi/mastodon4j). The app is located in ["app"]() directory. By using this app, you can browse the timeline of a public instance or log in to your own Mastodon account and browse your home timeline.   

* In the log in page:
   
<img src="https://github.com/ec500-software-engineering/case-study-ZeyuKeithFu/blob/master/assets/appdemo1.png" width="360" height="640">
   
* Enter an instance name and click ```Browse Instance```, you can view all the public contents published in this instance: 
   
<img src="https://github.com/ec500-software-engineering/case-study-ZeyuKeithFu/blob/master/assets/appdemo2.png" width="720" height="640">
   

   
## Defect
### Inconvenient direct message function
In Mastodon, although DMs can be created between users from different instances, they are still implemented by toots. A set of DMs is actually a toot only visible to the user in the conversation. And by replying this toot, two users are likely talking to each other. This can be sometimes not that convenient, say if you want to check your conversation history. And sometimes it is not that user-friendly.   
I think a chatting window function is extremely needed in Mastodon.   
   
### Comparatively small user groups
The number of Mastodon users is not big. Even the largest instance of Mastodon has only 53K people (not a big number compared to other social networks). This may sometimes make Mastodon less attractive to new users.
