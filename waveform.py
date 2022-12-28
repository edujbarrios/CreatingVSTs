import scipy.io.wavefile as wav
import matplotlib.pyplot as plt

# Lee el archivo de audio
fs, data = wav.read("audio.wav")

# Obtiene el número de canales y la duración del archivo
num_channels = data.shape[1]
duration = data.shape[0] / fs

# Selecciona un canal para mostrar la onda
channel = data[:, 0]

# Crea un eje de tiempo para la señal
time = np.linspace(0, duration, data.shape[0])

# Dibuja la onda del archivo de audio
plt.plot(time, channel)
plt.xlabel("Tiempo (s)")
plt.ylabel("Amplitud")
plt.title("Onda del audio")
plt.show()
