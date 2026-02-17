from graphics.circle import area as ar , circumference as circu
import graphics._3D_graphics.sphere

r=float(input('Enter the radius of the circle: '))
print('Area of circle is',ar(r),'and circumference is',circu(r))

rad=float(input('Enter the radius of the sphere: '))
print('SA of the sphere is',graphics._3D_graphics.sphere.surface_area(rad))
print('Volume of the sphere is',graphics._3D_graphics.sphere.volume(rad))