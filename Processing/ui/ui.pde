int scene = 0; 
Button botónjugar, botónopciones, botónsalir;
PFont fuentePrincipal, fuenteOpciones, fuenteSalir, fuenteJugar;
PImage fondo;

void setup() {
  size(720, 435);
  fondo = loadImage("fondosonic.png");  
  
  // Fuentes
  fuentePrincipal = createFont("Arial", 24);
  fuenteJugar = createFont("Arial",24);
  fuenteOpciones = createFont("Arial", 24); 
  fuenteSalir = createFont("Arial", 24); 
  
  // Botones
  botónjugar = new Button(width/2 - 50, height/2 - 30, 100, 40, "Jugar", fuentePrincipal);
  botónopciones = new Button(width/2 - 75, height/2 + 20, 150, 40, "Opciones", fuenteOpciones);
  botónsalir = new Button(width/2 - 50, height/2 + 70, 100, 40, "Salir", fuenteSalir);
}

void draw() {
  background(0);
  
  if (scene == 0) {
    mainMenu();
  } else if (scene == 1) {
    gameScreen();
  } else if (scene == 2) {
    optionsScreen();
  }
}

void mainMenu() {
  image(fondo, 0, 0, width, height);  
  
  fuentePrincipal = createFont("NiseSegaSonic", 36); 
  textFont(fuentePrincipal);
  fill(250);
  textAlign(CENTER);
  textSize(32);
  
  drawTextWithOutline("¡Bienvenido al juego!", width/2, 120, color(255, 217, 47), color(26, 91, 203), 3);
  
  botónjugar.display();
  botónopciones.display();
  botónsalir.display();
}

void gameScreen() {
  background(50, 150, 50);
  fill(250);
  textAlign(CENTER);
  textSize(32);
  text("Juego en Progreso...", width/2, height/2);
  
  fill(255);
  textSize(16);
  text("Presiona 'M' para regresar al menú", width/2, height - 30);
}

void optionsScreen() {
  background(100, 100, 255);
  fill(250);
  textAlign(CENTER);
  textSize(32);
  text("Opciones", width/2, height/2);
  
  fill(255);
  textSize(16);
  text("Presiona 'M' para regresar al menú", width/2, height - 30);
}

void keyPressed() {
  if (key == 'm' || key == 'M') {
    scene = 0; 
  }
}

void mousePressed() {
  if (botónjugar.isMouseOver()) {
    scene = 1; 
  } else if (botónopciones.isMouseOver()) {
    scene = 2; 
  } else if (botónsalir.isMouseOver()) {
    exit(); 
  }
}

class Button {
  float x, y, w, h;
  String label;
  PFont fuente;
  
  Button(float tempX, float tempY, float tempW, float tempH, String tempLabel, PFont tempFuente) {
    x = tempX;
    y = tempY;
    w = tempW;
    h = tempH;
    label = tempLabel;
    fuente = tempFuente; 
  }
  
  void display() {
    if (isMouseOver()) {
      fill(200);
    } else {
      fill(150);
    }
    rect(x, y, w, h);
    fill(0);
    textFont(fuente); 
    textAlign(CENTER, CENTER);
    text(label, x + w/2, y + h/2);
  }
  
  boolean isMouseOver() {
    return mouseX > x && mouseX < x + w && mouseY > y && mouseY < y + h;
  }
}

void drawTextWithOutline(String txt, float x, float y, color textColor, color outlineColor, float outlineThickness) {
  textFont(fuentePrincipal);
  textAlign(CENTER);
  
  fill(outlineColor);
  for (float dx = -outlineThickness; dx <= outlineThickness; dx += 1) {
    for (float dy = -outlineThickness; dy <= outlineThickness; dy += 1) {
      text(txt, x + dx, y + dy);
    }
  }

  fill(textColor);
  text(txt, x, y);
}
