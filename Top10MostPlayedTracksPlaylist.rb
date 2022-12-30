require 'rspotify'

RSpotify.authenticate(client_id: 'your_client_id', client_secret: 'your_client_secret')

# Retrieve the top 10 
most_played_tracks = RSpotify::User.find('me').top_tracks(time_range: '2022')[0..9] #array of top 10 tracks of 2022

# Create a new playlist in Spotify
playlist_name = 'Top 10 most played tracks of the year'
playlist = RSpotify::Playlist.create(user_id: 'user_id', name: playlist_name, public: true)

# Add the top 10 most played tracks to the playlist
playlist.add_tracks(most_played_tracks)
