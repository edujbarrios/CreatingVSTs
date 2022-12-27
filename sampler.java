import com.synthbot.audioplugin.vst.JVSTPlugin;
import com.synthbot.audioplugin.vst.JVSTPluginPrograms;

public class Sampler extends JVSTPlugin {
  private float[] samples;
  private float pitch;

  public Sampler(long wrapper) {
    super(wrapper);
  }

  @Override
  public void processAudio(float[][] inputs, float[][] outputs) {
    float[] inL = inputs[0];
    float[] inR = inputs[1];
    float[] outL = outputs[0];
    float[] outR = outputs[1];

    for (int i = 0; i < outL.length; i++) {
      int sampleIndex = (int) (i * pitch);
      float sample = samples[sampleIndex % samples.length];
      outL[i] = sample;
      outR[i] = sample;
    }
  }

  @Override
  public float getParameter(int index) {
    switch (index) {
      case 0:
        return pitch;
      default:
        return 0;
    }
  }

  @Override
  public void setParameter(int index, float value) {
    switch (index) {
      case 0:
        pitch = value;
        break;
    }
  }

  @Override
  public int getNumPrograms() {
    return 1;
  }

  @Override
  public String getProgramName(int index) {
    return "Sampler";
  }

  @Override
  public void setProgram(int index) {
  }

  @Override
  public JVSTPluginPrograms getPrograms() {
    return null;
  }
}
