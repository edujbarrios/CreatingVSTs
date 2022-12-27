import pyvst

class Sampler(pyvst.Plugin):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)

        # Create a list to store the samples
        self.samples = []

        # Create a parameter for the pitch of the sample
        self.pitch_param = pyvst.FloatParam(0.5, min=0.0, max=1.0, default=0.5, displayName="Pitch")
        self.add_param(self.pitch_param)

    def get_parameter(self, index):
        if index == 0:
            return self.pitch_param.value
        else:
            return 0.0

    def set_parameter(self, index, value):
        if index == 0:
            self.pitch_param.value = value

    def process_audio(self, inputs, outputs):
        # Get the audio input and output buffers
        in_l, in_r = inputs
        out_l, out_r = outputs

        # Process the audio samples
        for i in range(len(out_l)):
            # Calculate the pitch-shifted sample index
            sample_index = int(i * self.pitch_param.value)

            # Get the sample from the list of samples
            sample = self.samples[sample_index % len(self.samples)]

            # Write the sample to the output buffers
            out_l[i] = sample
            out_r[i] = sample
