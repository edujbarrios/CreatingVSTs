require 'sound_processing'

# Load the audio file
audio = SoundProcessing::Audio.new("../ejemplo_sin_masterizar.wav")

# Apply equalization to the audio file
audio.equalize(100, -6)

# Apply compression to the audio file
audio.compress(2, -12, 0.5)

# Apply limiting to the audio file
audio.limit(-0.5, 0.5)

# Save the processed audio file
audio.save("ejemplo_masterizado“.wav")
