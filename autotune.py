import sounddevice as sd
import numpy as np
import pysndfx

# Create a pysndfx processor with autotune effect
fx = (
    pysndfx.AudioEffectsChain()
    .autotune(semitones=2)
    .build()
)

def callback(indata, outdata, frames, time, status):
    # Process the input audio using the pysndfx processor
    outdata[:] = fx(indata)

# Set up audio streaming using sounddevice
stream = sd.InputOutputStream(
    channels=2, callback=callback,
    samplerate=44100, blocksize=1024
)

with stream:
    # Start audio streaming and apply the autotune effect in real-time
    sd.sleep(10000)
