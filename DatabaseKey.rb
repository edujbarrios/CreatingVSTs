require 'musicbrainz'

# Keep in mind that these tracks must be loaded in the database
song_title = 'song_title'
artist_name = 'artist_name'

# Search for the song in the MusicBrainz database
query = MusicBrainz::Webservice::Query.new
results = query.search(:recording, { :artist => artist_name, :recording => song_title })

# Extract the key of the first result (if there are any results)
if !results.empty?
  recording = results.first
  puts "Key of #{song_title} by #{artist_name}: #{recording.key}"
else
  puts "Unable to find #{song_title} by #{artist_name} in the MusicBrainz database"
end
