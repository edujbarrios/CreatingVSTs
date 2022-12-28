extern crate rodio;
extern crate plotters;

use rodio::Source;
use plotters::prelude::*;

fn main() {
    // Abre el archivo de audio
    let file = std::fs::File::open("audio.wav").unwrap();
    let source = rodio::Decoder::new(std::io::BufReader::new(file)).unwrap();

    // Convierte la señal a un arreglo de valores de punto flotante
    let samples: Vec<f32> = source.convert_samples().collect();

    // Dibuja la onda del archivo de audio
    let root =
        BitMapBackend::new("waveform.png", (800, 600)).into_drawing_area();
    root.fill(&WHITE).unwrap();
    let mut chart = ChartBuilder::on(&root)
        .caption("Onda del archivo de audio", ("sans-serif", 50))
        .build_cartesian_2d(-1.0..1.0, -1.0..1.0)
        .unwrap();
    chart
        .draw_series(LineSeries::new(
            samples.iter().enumerate().map(|(x, y)| (x as f32, *y)),
            &BLACK,
        ))
        .unwrap();
    chart
        .configure_mesh()
        .x_label_formatter(&|x| format!("{}", x))
        .y_label_formatter(&|y| format!("{}", y))
        .draw()
        .unwrap();
    root.present().unwrap();
}
