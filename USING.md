## Using the Palette Extension

The NetLogo palette extension allows to map values to colors. The colors go beyond NetLogo colors, including ColorBrewer color schemes or arbitrary RGB colors. Additionally, it provides a primitive to map to color gradients and a primitive to launch a ColorBrewer dialog for easy scheme selection.

## Getting Started

To get started with palettes add to the top of your Code tab:

```
extensions [palette]
```

you can then call any of the primitives by adding `palette:` before the primitive:

```
palette:scale-gradient
palette:scale-scheme

palette:scheme-color
palette:scheme-dialog
```

The palette extension primitives return a list containing RGB colors `[[r g b][r g b]...[r g b]]`, except for `palette:scheme-dialog` which opens a dialog.

### What colors should I use ?

ColorBrewer has many colors where to start. ColorBrewer has three schemes Sequential, Divergent and Qualitative. The use of ColorBrewer for maps is discussed at length in this paper (Harrower, Brewer 2003). Choosing the right colors is a design problem, thus, there are many acceptable solution. However, these guidelines might be useful for choosing colors in Agent Based Models:

* Sequential colors are best for continuous natural phenomena models such as as heat diffusion in physics or fire in earth sciences.
* Divergent colors are useful for highlighting a middle value in a model. It can be also applied to the heat diffusion model if the goal is to highlight the middle temperature.
* Qualitative colors are best for choosing colors in models where color denotes category and not value.
* For agents that cover large areas avoid strong colors and try to use pastel colors. However, for a low number of small isolated agents try to use strong colors such as such a accent.
* The main goal is to avoid having a large area covered with agents with a bright color and or having small areas having a muted pastel color.
* If you are coloring both turtles and patches, make sure they have different ranges of hue, saturation and value. E.g. Use different hues of pastel for patches and accent for turtles

### Should I use a continuous color gradient or just a discrete color set ?

The answer depends on the task that your will be asking from your user.

For example, gradients are more aesthetic thus are more memorable than discrete colors. Consequently, a gradient can be a better choice for presentations where the main goal of the image is to be attractive and memorable. However, binning values in a discrete set of colors simplifies tasks such as estimation and counting by removing unnecessary detail to display the big picture. Thus, discrete colors can be a better choice for a paper where the user will have the time and interest to study the visualization.

In order to see the difference you can turn on and off the gradient in the Heat Diffusion model. You can observe that turning gradient on makes the model more aesthetic, but it becomes harder to estimate the value of a patch at a given position.

### Example Models

There is an example of using the palette primitives in the Code Examples section of the models library:

* Palette Example

And one Sample Model that uses the extension:

* Heat Diffusion - Alternative Gradient

### Further Reading

* Be sure to check the [ColorBrewer web page](http://colorbrewer2.org/)
* To get a deeper understanding of how to use the color schemes read the ColorBrewer paper (Harrower, Brewer 2003)

