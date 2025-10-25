library(tidyverse)
library(Amelia) #ver NAs
library(patchwork) #pegar gráficas
library(effsize) #effect size
install.packages("car")
library(car) # kruskal wallis

df <- read_excel("C:/Users/ASUS/Downloads/datos_medicos.xlsx")

x <- df %>%
  filter(Presion == "PresionSistolica") %>%
  pull(Valores)
y <- df %>%
  filter(Presion == "PresionDiastolica") %>%
  pull(Valores) 

dfps <- df %>% 
  filter(Presion == "PresionSistolica")

dfpd <- df %>%
  filter(Presion == "PresionDiastolica") 


# EDA ----

url <- "https://raw.githubusercontent.com/cdeoroaguado/Datos/main/datamanip/sales.csv"
datos <- read.csv(url)
url <- "https://raw.githubusercontent.com/cdeoroaguado/Datos/refs/heads/main/datamanip/bank.csv"
datos <- read.csv(url, sep = ";", stringsAsFactors = TRUE)
head(datos,n=5)
dim(datos)
colnames(datos)
str(datos)
datos %>% 
  select(-X,-date) -> df #quitar columnas
datos$var <- as.factor(datos$var)
df %>% #faltantes
  summarise(across(everything(), ~ sum(is.na(.)), .names = "NA_{.col}"))
missmap(df)

df %>% #tablita resumen variable target
  summarise(
    n = length(weekly_sales),
    media = mean(weekly_sales),
    ds = sd(weekly_sales),
    mediana = median(weekly_sales),
    minimo = min(weekly_sales),
    maximo = max(weekly_sales),
    Q1 = quantile(weekly_sales, 0.25),
    Q3 = quantile(weekly_sales, 0.75),
    IQR = IQR(weekly_sales)
  )

df %>% #histograma
  ggplot(aes(x = weekly_sales)) +
  geom_histogram(aes(y = after_stat(density)), 
                 binwidth = 5000, 
                 fill = "#2c7fb8", 
                 color = "white", 
                 alpha = 0.6) +
  geom_density(color = "darkblue", linewidth = 1.2) +
  labs(
    title = "Distribución de Ventas Semanales",
    x = "Ventas Semanales (USD)",
    y = "Densidad"
  ) +
  theme_bw()

df %>% #boxplot
  ggplot(aes(x = "", y = weekly_sales)) +
  geom_boxplot(fill = "#a6cee3", color = "#1f78b4", outlier.color = "red") +
  stat_summary(
    fun = mean,
    geom = "point",
    shape = 20,
    size = 3,
    color = "black"
  ) +
  labs(
    title = "Diagrama de cajas y bigotes de ventas semanales",
    x = "",
    y = "Ventas Semanales (USD)"
  ) +
  theme_bw()

df %>% #num 
  summarise(
    n = length(temperature_c),
    media = mean(temperature_c),
    ds = sd(temperature_c),
    mediana = median(temperature_c),
    minimo = min(temperature_c),
    maximo = max(temperature_c),
    Q1 = quantile(temperature_c, 0.25),
    Q3 = quantile(temperature_c, 0.75),
    IQR = IQR(temperature_c)) %>%
  mutate(variable = "temperature_c") -> var_num_temp
bind_rows(var_num_temp, var_num_fuel, var_num_unemploy) %>%
  select(variable, everything())

p1 <- df %>% #boxplot num
  ggplot(aes(x="", y = temperature_c)) +
  geom_boxplot(fill = "#1f77b4", alpha = 0.7) +
  labs(
    title = "Distribucion de temperatura",
    y = "Temperatura (°C)",
    x = ""
  ) +
  theme_bw()
p1 + p2 + p3  

tabla_type <- df %>% #cat
  count(type, name = "Frecuencia") %>%
  mutate(
    Porcentaje = round(Frecuencia / sum(Frecuencia) * 100, 2),
    Variable = "type",
    Categoria = as.character(type)
  ) %>%
  select(Variable, Categoria, Frecuencia, Porcentaje)
bind_rows(tabla_type, tabla_department, tabla_holiday)

tabla_type_b <- df %>%#grafico de barras
  count(type, name = "Frecuencia") %>%
  mutate(Porcentaje = round(Frecuencia / sum(Frecuencia) * 100, 1),
         Etiqueta = paste0(Frecuencia, " (", Porcentaje, "%)"))
ggplot(tabla_type_b, aes(x = type, y = Frecuencia)) +
  geom_col(fill = "#008B8B", width = 0.6) +
  geom_text(aes(label = Etiqueta), vjust = -0.5, size = 5) +
  facet_wrap(~ "Distribución de la variable type") + 
  scale_y_continuous(expand = expansion(mult = c(0, 0.15))) +
  labs(x = "Tipo de tienda", y = "Frecuencia (Porcentaje)") +
  theme_bw(base_size = 14) +
  theme(
    plot.title = element_blank(),
    strip.background = element_rect(fill = "gray80", color = NA),
    strip.text = element_text(face = "bold"),
    panel.grid.major.x = element_blank()
  )

tabla_department_b <- df %>% #grafico de frecuencia
  count(department, name = "Frecuencia") %>%
  mutate(Porcentaje = round(Frecuencia / sum(Frecuencia) * 100, 1),
         Etiqueta = paste0(Frecuencia, " (", Porcentaje, "%)"))
ggplot(tabla_department_b, aes(x = factor(department), y = Frecuencia)) +
  geom_col(fill = "#008B8B", width = 0.6) +
  geom_text(aes(label = Etiqueta), hjust = -0.1, size = 3) +
  facet_wrap(~ "Distribución de la variable department") + 
  scale_y_continuous(expand = expansion(mult = c(0, 0.10))) +
  labs(x = "Departamento", y = "Frecuencia (Porcentaje)") +
  coord_flip() +
  theme_bw(base_size = 14) +
  theme(
    plot.title = element_blank(),
    strip.background = element_rect(fill = "gray80", color = NA),
    strip.text = element_text(face = "bold"),
    panel.grid.major.y = element_blank(),
    axis.text.y = element_text(size = 8)  
  )

df %>% # Diagrama de dispersión: weekly_sales vs temperature_c
  ggplot(aes(x = temperature_c, y = weekly_sales)) +
  geom_point(alpha = 0.4, color = "#1E90FF") +
  geom_smooth(method = "lm", formula = y ~ x, se = FALSE, color = "red") +
  labs(x = "Temperatura (°C)",
       y = "Ventas semanales (uds)"
  ) +
  theme_bw()+
  facet_grid(.~ "Dispersión entre Weekly Sales y Temperature (°C)")

type_week <- df %>% #comparacion de la variable weekly_sales con las categóricas
  group_by(type) %>%
  summarise(n = length(weekly_sales),
            media = mean(weekly_sales),
            ds = sd(weekly_sales),
            mediana = median(weekly_sales),
            minimo = min(weekly_sales),
            maximo = max(weekly_sales),
            Q1 = quantile(weekly_sales, 0.25),
            Q3 = quantile(weekly_sales, 0.75),
            IQR = IQR(weekly_sales)) %>%
  mutate(variable = "type", niveles = as.character(type)) %>%
  select(variable, niveles, everything(), -type)
bind_rows(type_week, store_week, dep_week, holi_week)

df %>% #cat (target) vs cat
  group_by(y) %>%
  count(marital, name = "n") %>%
  mutate(categoria = marital,
         variable = "marital",
         porcentaje = (n / sum(n)) * 100) %>%
  select(y, variable, categoria, n, porcentaje)

df %>% #boxplot num (target) vs cat
  ggplot(aes(x = type, y = weekly_sales)) +
  geom_boxplot(fill = "#87CEFA", outlier.colour = "red", outlier.shape = 16) +
  stat_summary(fun = mean, geom = "point", shape = 18, size = 3, color = "darkblue") +
  labs(x = "Tipo de tienda",
       y = "Ventas semanales (usd)"
  ) +
  theme_bw()+
  facet_grid(.~"Distribución de Weekly Sales por tipo de tienda")

library(gridExtra) # varios boxplots 
grid.arrange(p1, p2,p3,p4,p5, ncol = 2,newpage = FALSE)


# Normalidad
ks.test(scale(dfps$Valores),pnorm)
ks.test(scale(dfpd$Valores),pnorm)
ks.test(x, "pnorm", mean = media, sd = desviacion)

datis %>%
  group_by(metodo) %>%
  summarise(n = length(tiempo_reaccion),
            estd = shapiro.test(tiempo_reaccion)$statistic,
            p_val = shapiro.test(tiempo_reaccion)$p.value)
shapiro.test(datos$antes)
shapiro para <500

# Medias con est. param. ----
test z: se conoce desv. est. pobl. y los tam. muestr. son grandes

test t: desv. pobl. desconocidas
t.test(dfps$Valores,
       dfpd$Valores,
       paired = FALSE,
       var.equal = TRUE)  

Supuestos t test: 
  -independencia
  -normalidad
  -homocedasticidad -> levene, f, bartless, si no se cumple -> welch
  gdl = n1+n2-2
  # Función para calcular los grados de libertad de Welch
  welch_df <- function(x, y) {
    n1 <- length(x)
    n2 <- length(y)
    s1 <- var(x)
    s2 <- var(y)
    
    num <- (s1/n1 + s2/n2)^2
    den <- ((s1/n1)^2 / (n1 - 1)) + ((s2/n2)^2 / (n2 - 1))
    
    df <- num / den
    return(df)
  }
  # Función para calcular SE (error estándar)
  calc_SE <- function(s1, s2, n1, n2) {
    SE <- sqrt((s1^2 / n1) + (s2^2 / n2))
    return(SE)
  }
  # Calcular estadístico t
    (mean(x) - mean(y)) / SE
  
  # d de cohen
  La d de Cohen representa la diferencia estandarizada entre medias, es decir,
  cuántas desviaciones estándar separan en promedio los grupos comparados:
    
    d: cohen.d(dfps$Valores,
               dfpd$Valores,
               paired = FALSE)
    o 
    d <- abs(mean(x)-mean(y))/sqrt(sp2)
    
    Var(d)≈ (n1+n2)/n1​+n2​​+2(n1​+n2​−2)d2​
    
  # sp desv. est. ponderada
  sqrt(((n1 - 1) * var(x) + (n2 - 1) * var(y)) / (n1 + n2 - 2)) #var iguales
  # sp promedio cuadratico simple
  sqrt((var(x) + var(y)) / 2)
  
  d  ≤  0.2  : tamaño del efecto pequeño
  d  ≈  0.5  : tamaño del efecto mediano
  d  ≥  0.8  : tamaño del efecto grande
  
  #r de pearson t test
  fuerza de asociación entre una variable categórica binaria (grupo) y una variable continua
  r <- sqrt(t^2/t^2+gdl)
  r  ≤  0.1  : tamaño del efecto pequeño
  r  ≥  0.3  : tamaño del efecto mediano
  r  ≥  0.5  : tamaño del efecto grande


# Medias grupos pareados est. param. ----
se calcula para un mismo individuo: 
    di = xi-yi
    d rayita = mean(x - y, na.rm = TRUE)
Supuestos:
  -Normalidad
  -Homocedasticidad no es necesario
Estadístico de prueba: t = (d rayita / (sd/sqrt(n))) ~ t n-1
  
# Grupos indep. est. no param.
matt whitney-wilcoxon: compara dos muestras independientes, sin asumir normalidad,
para determinar si proceden de poblaciones con distr similares
contrasta si la probabalidad de que una observacion de una poblacion sea mayor 
que una de la otra es 0.5
  H0: P(X>Y) = 0.5
  H1: P(X<Y) =! 0.5
  independencia 
  no normalidad ni homocedasticidad
  ordinalidad
  
  library(nortest)
  
  df %>%
    group_by(smoke) %>%
    summarise(n = length(weight),
              est_ks = ks.test(scale(weight),'pnorm')$statistic,
              p_ks = ks.test(scale(weight),'pnorm')$p.value,
              estsw = shapiro.test(weight)$statistic,
              p_sw = shapiro.test(weight)$p.value,
              est_lt = lillie.test(weight)$statistic,
              p_lt = lillie.test(weight)$p.value)
  
  library(rstatix)
  df %>%
    wilcox_test(weight ~ smoke, 
                paired = FALSE)
  
  Dado que no se cumple con el supuesto de normalidad en los grupos analizados,
  la comparación de varianzas debe realizarse mediante pruebas robustas a esta condición.
  En este contexto, se recomienda emplear el test de Levene o el test no paramétrico de Fligner-Killeen, ambos diseñados para evaluar la homogeneidad de varianzas y que utilizan la mediana como medida de tendencia central,
  lo que los hace adecuados en presencia de datos no normales.
  
  leveneTest(weight ~ smoke, data = df, center = "median")
  ## Levene's Test for Homogeneity of Variance (center = "median")
  ##        Df F value Pr(>F)
  ## group   1  0.4442 0.5062
  ##       148
  
  
  library(rstatix)
  
  df %>%
    wilcox_effsize(weight ~ smoke, paired = FALSE)
  ## # A tibble: 1 × 7
  ##   .y.    group1    group2 effsize    n1    n2 magnitude
  ## * <chr>  <chr>     <chr>    <dbl> <int> <int> <ord>    
  ## 1 weight nonsmoker smoker   0.123   100    50 small
  
# Grupos pareados est. no param.
wilcoxon signed rank test:
dependencia
ordinalidad
no normalidad
opera sobre medianas
tamaño pequeño

datos %>%
  rstatix::wilcox_test(Q1 ~ Experimento, paired = TRUE)

datos %>%
  rstatix::wilcox_effsize(Q1 ~ Experimento, paired = TRUE)

  p < error = rechazas H0
  F > F crit = rechazas h0
  

# Test de normalidad
ks.test(scale(dfps$Valores),pnorm)
ks.test(scale(dfpd$Valores),pnorm)

# Con var.test ----
var.test(x,y)

# Manual con el teorema 

n1 <- length(x)
n2 <- length(y)
s1 <- sum((x-mean(x))^2)/(n1-1)
s2 <- sum((y-mean(y))^2)/(n2-1)

F0 <- s1/s2
df1 <- n1-1
df2 <- n2-1

pvalor <- 2 * pf(F0, df1, df2, lower.tail = TRUE)

alpha <- 0.05
int_inf <- (s1/s2) * (1/qf(1-alpha/2, df1, df2))
int_sup <- (s1/s2) * (1/qf(alpha/2, df1, df2))


# Con t.test ----
t.test(dfps$Valores,
       dfpd$Valores,
       paired = FALSE,
       var.equal = TRUE)

# Manual teorema diferencia de medias 

gdl <- n1+n2-2
sp2 <- ((n1-1)*s1 + (n2-1)*s2) / gdl
t_est <- (mean(x)-mean(y)) / sqrt(sp2 * (1/n1 + 1/n2))
pvalue <- 2 * (1-pt(t_est, df=gdl))

alpha <- 0.05
t_crit <- qt(1 - alpha/2, df=gdl)
inf <- (mean(x) - mean(y)) - t_crit*sqrt(sp2 * (1/n1 + 1/n2))
sup <- (mean(x) - mean(y)) + t_crit*sqrt(sp2 * (1/n1 + 1/n2))

list(
  sp2 = sp2,
  t = t_est,
  gl = gdl,
  pvalue = pvalue,
  IC_95 = c(inf, sup)
)


# Effect size 

cohen.d(dfps$Valores,
        dfpd$Valores,
        paired = FALSE)

d <- abs(mean(x)-mean(y))/sqrt(sp2)
intd <- 


# Anova manual----

df2 <- data.frame(Empleados = c(0.66, 0.63, 0.65, 0.69, 0.44, 0.63, 0.61, 0.42, 0.59, 0.46),
                 Agricultores = c(0.65, 0.60, 0.69, 0.73, 0.52, 0.85, 0.81, NA, NA, NA),
                 NoExpuestos = c(0.93, 0.99, 0.96, 0.74, 0.81, 0.93, 0.63, 0.68, 0.99, NA))

df_long <- stack(df2)  # convierte a formato largo
colnames(df_long) <- c("Valor", "Grupo")

empleado = na.omit(df2$Empleados)
agricultores = na.omit(df2$Agricultores)
noexpuesto = na.omit(df2$NoExpuestos)

modelo <- aov(Valor ~ Grupo, data=df_long)
summary(modelo)

n1 = length(empleado)
n2 = length(agricultores)
n3 = length(noexpuesto)

N = n1+n2+n3
k = ncol(df2)

xbar_1 = mean(empleado)
xbar_2 = mean(agricultores)
xbar_3 = mean(noexpuesto)
xbar_total <- (sum(empleado) + sum(agricultores) + sum(noexpuesto)) / N

SST = sum((empleado - xbar_total)^2) +
  sum((agricultores - xbar_total)^2) +
  sum((noexpuesto - xbar_total)^2) 

SSA = n1 * (xbar_1 - xbar_total)^2 +
      n2 * (xbar_2 - xbar_total)^2 +
      n3 * (xbar_3 - xbar_total)^2

SSE = SST - SSA

v1 <- k - 1
v2 <- N - k

MSA = SSA / (v1)
MSE = SSE / (v2)

F = MSA / MSE

alpha = 0.05
F_crit = qf(1-alpha, df1=v1, df2=v2)
pv = 1-pf(F, df1=v1, df2=v2)

decision <- ifelse(F > F_crit, "Se rechaza H_0", "No se rechaza H_0")
print(decision)
decision2 <- ifelse(F > F_crit, "Se rechaza H_0", "No se rechaza H_0")
print(decision)


# Ejercicio ----

datos <- data.frame(
  Grupo = rep(c("A", "B", "C"), each = 10),
  Calificaciones = c(75, 78, 80, 82, 85, 88, 90, 92, 95, 98,   # Grupo A
                     68, 70, 72, 74, 76, 78, 80, 82, 84, 86,   # Grupo B
                     60, 63, 66, 69, 72, 75, 78, 81, 84, 87)   # Grupo C
)

# Normalidad
datos %>%
  group_by(Grupo) %>%
  summarise(est = shapiro.test(Calificaciones)$statistic,
            p_v = shapiro.test(Calificaciones)$p.value)

# Homogeneidad de varianzas
bartlett.test(Calificaciones ~ Grupo, data=datos)

# Anova
modelo = aov(Calificaciones ~ Grupo, data=datos)
summary(modelo)

df3 <- data.frame(A= c(75, 78, 80, 82, 85, 88, 90, 92, 95, 98),   # Grupo A
                  B = c(68, 70, 72, 74, 76, 78, 80, 82, 84, 86),   # Grupo B
                  C = c(60, 63, 66, 69, 72, 75, 78, 81, 84, 87))   # Grupo C

A = na.omit(df3$A)
B = na.omit(df3$B)
C = na.omit(df3$C)

nA = length(A)
nB = length(B)
nC = length(C)

N = nA+nB+nC
k = ncol(df3)

xbar_1 = mean(A)
xbar_2 = mean(B)
xbar_3 = mean(C)
xbar_total <- (sum(A) + sum(B) + sum(C)) / N

SST = sum((A - xbar_total)^2) +
  sum((B - xbar_total)^2) +
  sum((C - xbar_total)^2) 

SSA = nA * (xbar_1 - xbar_total)^2 +
  nB * (xbar_2 - xbar_total)^2 +
  nC * (xbar_3 - xbar_total)^2

SSE = SST - SSA

v1 <- k - 1
v2 <- N - k

MSA = SSA / (v1)
MSE = SSE / (v2)

F = MSA / MSE

alpha = 0.05
F_crit = qf(1-alpha, df1=v1, df2=v2)
pv = 1-pf(F, df1=v1, df2=v2)

decision <- ifelse(F > F_critico, "Se rechaza H_0", "No se rechaza H_0")

print(decision)

decision <- ifelse(pvalor < alpha, "Se rechaza H_0", "No se rechaza H_0")

print(decision)


# Kruskal-Wallis ----

datis <- data.frame(
  metodo = c(rep("Metodo_A", 18), rep("Metodo_B", 18), rep("Metodo_C", 18)),
  tiempo_reaccion = c(
    1, 2, 3, 4, 5, 6, 7, 8, 9, 16, 27, 28, 29, 30, 51, 52, 53, 342,          # Método A
    40, 41, 42, 43, 44, 45, 46, 47, 48, 67, 88, 89, 90, 91, 92, 93, 94, 293, # Método B
    19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 25, 36, 37, 58, 59, 60, 71, 72   # Método C
  )
)

# Normalidad
datis %>%
  group_by(metodo) %>%
  summarise(n = length(tiempo_reaccion),
            estd = shapiro.test(tiempo_reaccion)$statistic,
            p_val = shapiro.test(tiempo_reaccion)$p.value)

# Homocedasticidad
leveneTest(tiempo_reaccion ~ metodo, data = datis)

# Kruskal-Wallis
kruskal.test(tiempo_reaccion ~ metodo, data = datis)

# Prueba post.hoc
pairwise.wilcox.test(x = datis$tiempo_reaccion,
                     g = datis$metodo,
                     p.adjust.method = "bonferroni")
































