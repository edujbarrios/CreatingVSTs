from pydub import AudioSegment

# Cargar el archivo de audio
audio = AudioSegment.from_file("input.wav", format="wav")

# Ajustar los niveles globales del archivo de audio
audio = audio + 6

# Aplicar ecualización al archivo de audio
audio = audio.high_pass_filter(100).low_pass_filter(-6)

# Aplicar compresión al archivo de audio
audio = audio.apply_compression(2, -12, 0.5)

# Aplicar limitación al archivo de audio
audio = audio.apply_gain(-0.5, 0.5)

# Guardar el archivo de audio masterizado
audio.export("output.wav", format="wav")
