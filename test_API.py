from Mastodon import Mastodon


## Create app. Run only once.
'''
Mastodon.create_app("ec500",
                    api_base_url="cmx.im", # Choose an avaliable Mastodon instance, my choice is 'cmx.im'
                    to_file='ec500_clientcred.secret'
)
'''

## Log in
mastodon = Mastodon(
    client_id='ec500_clientcred.secret',
    api_base_url='cmx.im'
)
mastodon.log_in(
    'YOUR_EMAIL_HERE', # Mastodon instance login email address
    'YOUR_PASSWORD_HERE', # Mastodon instance login password
    to_file='ec500_usercred.secret'
)

## Post by creating API instance
mastodon = Mastodon(
    access_token='ec500_usercred.secret',
    api_base_url='cmx.im'
)
mastodon.toot('Tooting from ec500 using #mastodonpy !')
