import PIL.Image
import os


photos_raw_path = [os.path.join("raw\photos", i) for i in os.listdir("raw\photos")]
dip_raw_path = [os.path.join("raw\dip", i) for i in os.listdir("raw\dip")]

photos_raw = [ i for i in os.listdir("raw\photos")]
dip_raw = [i for i in os.listdir("raw\dip")]

def resize_img(list_path,list,width,height,path):
    for i,j in zip(list_path, list): 
        img = PIL.Image.open(i)
        img.resize((width,height)).save(os.path.join(path, j))

if __name__ == "__main__":

    resize_img(photos_raw_path,photos_raw,960,480,"fixed\photos")
    resize_img(dip_raw_path,dip_raw,960,480,"fixed\dip")
