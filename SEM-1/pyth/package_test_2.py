from graphics.rectangle import *
import graphics._3D_graphics.cuboid as cb

le,br=map(float,input('Enter length and breadth with space: ').split())
print('Area of rectangle is',area(le,br),'and perimeter is',perimeter(le,br))

l,b,h=map(float,input('Enter length, breadth and height of cuboid with space: ').split())
print('SA of cuboid is',cb.surface_area(l,b,h),'and volume is',cb.volume(l,b,h))