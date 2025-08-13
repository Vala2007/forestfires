# Librería ----

install.packages("readxl")
install.packages("Amelia")
install.packages("patchwork")
install.packages("tidyverse")
install.packages("GGally")
install.packages("bookdown")
library(readxl)
library(Amelia)
library(tidyverse)
library(GGally)
library(patchwork)
library(dplyr)

# Datos ----
datos<- read_excel("C:/Users/ASUS/Downloads/forestfires_1_.xlsx")

# Estructura de los datos 
dim(datos)
colnames(datos)
str(datos)

# Valores nulos
datos %>%
  summarise(across(everything(), 
                   ~sum(is.na(.))))

# Otra formas de mirar NAs
missmap(datos)

# Crear data frame
df <- as.data.frame(datos)

# Análisis de la variable área ----

df %>%
  summarise(n=length(area), 
            prom = mean(area),
            ds = sd(area),
            mediana = median(area),
            RIC = IQR(area),
            minimo = min(area),
            maximo = max(area),
            Q1 = quantile(area, 0.25),
            Q3 = quantile(area, 0.75))

df %>%
  ggplot(aes(x=area)) + 
  geom_histogram(aes(y=after_stat(density))) + 
  geom_density(color="blue") + 
  theme_bw()

df %>%
  ggplot(aes(x = "", y = area)) +
  geom_boxplot(fill = "#a6cee3", color = "#1f78b4", outlier.color = "red") +
  stat_summary(
    fun = mean,
    geom = "point",
    shape = 20,
    size = 3,
    color = "black"
  ) +
  labs(
    title = "Diagrama de cajas y bigotes de área quemada",
    x = "",
    y = "Área quemada"
  ) +
  theme_bw()

df <- df %>%
  mutate(area_log = log1p(area))

df %>%
  summarise(n=length(area_log), 
            prom = mean(area_log),
            ds = sd(area_log),
            mediana = median(area_log),
            RIC = IQR(area_log),
            minimo = min(area_log),
            maximo = max(area_log),
            Q1 = quantile(area_log, 0.25),
            Q3 = quantile(area_log, 0.75))

df %>%
  ggplot(aes(x=area_log)) + 
  geom_histogram(aes(y=after_stat(density))) + 
  geom_density(color="blue") + 
  theme_bw()

df %>%
  ggplot(aes(x = "", y = area_log)) +
  geom_boxplot(fill = "#a6cee3", color = "#1f78b4", outlier.color = "red") +
  stat_summary(
    fun = mean,
    geom = "point",
    shape = 20,
    size = 3,
    color = "black"
  ) +
  labs(
    title = "Diagrama de cajas y bigotes de área quemada",
    x = "",
    y = "Área quemada"
  ) +
  theme_bw()

# Variables independientes numéricas ----

ggplot(df, aes(x = X, y = Y, size = area_log)) +
  geom_point(alpha = 0.5, color = "orange") +
  scale_x_continuous(breaks = 1:9) +
  scale_y_continuous(breaks = 1:9) +
  theme_bw() +
  labs(title = "Ubicación y magnitud de incendios")
df %>%
  count(X, Y) %>%
  ggplot(aes(x = X, y = Y, fill = n)) +
  geom_tile(color = "white") +
  scale_fill_gradient(low = "yellow", high = "red") +
  theme_bw() +
  labs(title = "Frecuencia de incendios por coordenada", fill = "Incendios")

df %>% 
  summarise(
    n = length(FFMC),
    media = mean(FFMC),
    ds = sd(FFMC),
    mediana = median(FFMC),
    minimo = min(FFMC),
    maximo = max(FFMC),
    Q1 = quantile(FFMC, 0.25),
    Q3 = quantile(FFMC, 0.75),
    IQR = IQR(FFMC)) %>%
  mutate(variable = "FFMC") -> ffmc

df %>% 
  summarise(
    n = length(DMC),
    media = mean(DMC),
    ds = sd(DMC),
    mediana = median(DMC),
    minimo = min(DMC),
    maximo = max(DMC),
    Q1 = quantile(DMC, 0.25),
    Q3 = quantile(DMC, 0.75),
    IQR = IQR(DMC)) %>% 
  mutate(variable = "DMC") -> dmc

df %>% 
  summarise(
    n = length(DC),
    media = mean(DC),
    ds = sd(DC),
    mediana = median(DC),
    minimo = min(DC),
    maximo = max(DC),
    Q1 = quantile(DC, 0.25),
    Q3 = quantile(DC, 0.75),
    IQR = IQR(DC)) %>% 
  mutate(variable = "DC")-> dc

df %>% 
  summarise(
    n = length(ISI),
    media = mean(ISI),
    ds = sd(ISI),
    mediana = median(ISI),
    minimo = min(ISI),
    maximo = max(ISI),
    Q1 = quantile(ISI, 0.25),
    Q3 = quantile(ISI, 0.75),
    IQR = IQR(ISI)) %>% 
  mutate(variable = "ISI")-> isi

df %>% 
  summarise(
    n = length(temp),
    media = mean(temp),
    ds = sd(temp),
    mediana = median(temp),
    minimo = min(temp),
    maximo = max(temp),
    Q1 = quantile(temp, 0.25),
    Q3 = quantile(temp, 0.75),
    IQR = IQR(temp)) %>% 
  mutate(variable = "temp")-> temp

df %>% 
  summarise(
    n = length(RH),
    media = mean(RH),
    ds = sd(RH),
    mediana = median(RH),
    minimo = min(RH),
    maximo = max(RH),
    Q1 = quantile(RH, 0.25),
    Q3 = quantile(RH, 0.75),
    IQR = IQR(RH)) %>% 
  mutate(variable = "RH")-> rh

df %>% 
  summarise(
    n = length(wind),
    media = mean(wind),
    ds = sd(wind),
    mediana = median(wind),
    minimo = min(wind),
    maximo = max(wind),
    Q1 = quantile(wind, 0.25),
    Q3 = quantile(wind, 0.75),
    IQR = IQR(wind)) %>% 
  mutate(variable = "wind")-> wind

df %>% 
  summarise(
    n = length(rain),
    media = mean(rain),
    ds = sd(rain),
    mediana = median(rain),
    minimo = min(rain),
    maximo = max(rain),
    Q1 = quantile(rain, 0.25),
    Q3 = quantile(rain, 0.75),
    IQR = IQR(rain)) %>% 
  mutate(variable = "rain")-> rain

bind_rows(ffmc, dmc, dc, isi, temp, rh, wind, rain) %>%
  select(variable, everything())

# Variables categóricas ----

df$month <- factor(df$month,
                   levels = c("jan", "feb", "mar", "apr", "may", "jun",
                              "jul", "aug", "sep", "oct", "nov", "dec"))

tabla_month <- df %>%
  count(month, name="Frecuencia") %>%
  mutate(
    Porcentaje = round(
      (Frecuencia/sum(Frecuencia))*100,1),
    Etiqueta = paste0(Frecuencia, " (",Porcentaje,"%)"))

g_mes <- ggplot(tabla_month, aes(x = month, y = Frecuencia)) +
  geom_col(fill = "#A0ABFF", width = 0.6) +
  geom_text(aes(label = Etiqueta), vjust = -0.5, size = 3) +
  facet_wrap(~ "Distribución de la variable month") + 
  scale_y_continuous(expand = expansion(mult = c(0, 0.15))) +
  labs(x = "Mes del año", y = "Frecuencia (Porcentaje)") +
  theme_bw(base_size = 8) +
  theme(
    plot.title = element_blank(),
    strip.background = element_rect(fill = "gray80", color = NA),
    strip.text = element_text(face = "bold"),
    panel.grid.major.x = element_blank()
  )

df$day <- factor(df$day,
                 levels = c("mon", "tue", "wed", "thu", "fri", "sat", "sun"))

tabla_day <- df %>%
  count(day, name="Frecuencia") %>%
  mutate(
    Porcentaje = round(
      (Frecuencia/sum(Frecuencia))*100,1),
    Etiqueta = paste0(Frecuencia, " (",Porcentaje,"%)"))

g_dia <- ggplot(tabla_day, aes(x = day, y = Frecuencia)) +
  geom_col(fill = "#A0ABFF", width = 0.6) +
  geom_text(aes(label = Etiqueta), vjust = -0.5, size = 3) +
  facet_wrap(~ "Distribución de la variable day") + 
  scale_y_continuous(expand = expansion(mult = c(0, 0.15))) +
  labs(x = "Día de la semana", y = "Frecuencia (Porcentaje)") +
  theme_bw(base_size = 8) +
  theme(
    plot.title = element_blank(),
    strip.background = element_rect(fill = "gray80", color = NA),
    strip.text = element_text(face = "bold"),
    panel.grid.major.x = element_blank()
  )

g_mes / g_dia


# Análisis bivariado num vs num ----

df %>% 
  ggplot(aes(x = FFMC, y = area_log)) +
  geom_point(alpha = 0.4, color = "#1E90FF") +
  geom_smooth(method = "lm", formula = y ~ x, se = FALSE, color = "red") +
  labs(x = "FFMC",
       y = "Área quemada"
  ) +
  theme_bw()+
  facet_grid(.~ "Dispersión entre FFMC y área quemada")

df %>% 
  ggplot(aes(x = DMC, y = area_log)) +
  geom_point(alpha = 0.4, color = "#1E90FF") +
  geom_smooth(method = "lm", formula = y ~ x, se = FALSE, color = "red") +
  labs(x = "DMC",
       y = "Área quemada"
  ) +
  theme_bw()+
  facet_grid(.~ "Dispersión entre DMC y área quemada")

df %>% 
  ggplot(aes(x = DC, y = area_log)) +
  geom_point(alpha = 0.4, color = "#1E90FF") +
  geom_smooth(method = "lm", formula = y ~ x, se = FALSE, color = "red") +
  labs(x = "DMC",
       y = "Área quemada"
  ) +
  theme_bw()+
  facet_grid(.~ "Dispersión entre DC y área quemada")

df %>% 
  ggplot(aes(x = ISI, y = area_log)) +
  geom_point(alpha = 0.4, color = "#1E90FF") +
  geom_smooth(method = "lm", formula = y ~ x, se = FALSE, color = "red") +
  labs(x = "ISI",
       y = "Área quemada"
  ) +
  theme_bw()+
  facet_grid(.~ "Dispersión entre ISI y área quemada")

df %>% 
  ggplot(aes(x = temp, y = area_log)) +
  geom_point(alpha = 0.4, color = "#1E90FF") +
  geom_smooth(method = "lm", formula = y ~ x, se = FALSE, color = "red") +
  labs(x = "Temperatura",
       y = "Área quemada"
  ) +
  theme_bw()+
  facet_grid(.~ "Dispersión entre temperatura y área quemada")

df %>% 
  ggplot(aes(x = RH, y = area_log)) +
  geom_point(alpha = 0.4, color = "#1E90FF") +
  geom_smooth(method = "lm", formula = y ~ x, se = FALSE, color = "red") +
  labs(x = "Humedad relativa",
       y = "Área quemada"
  ) +
  theme_bw()+
  facet_grid(.~ "Dispersión entre RH y área quemada")

df %>% 
  ggplot(aes(x = rain, y = area_log)) +
  geom_point(alpha = 0.4, color = "#1E90FF") +
  geom_smooth(method = "lm", formula = y ~ x, se = FALSE, color = "red") +
  labs(x = "Lluvia",
       y = "Área quemada"
  ) +
  theme_bw()+
  facet_grid(.~ "Dispersión entre lluvia y área quemada")

df %>% 
  ggplot(aes(x = DMC, y = area_log)) +
  geom_point(alpha = 0.4, color = "#1E90FF") +
  geom_smooth(method = "lm", formula = y ~ x, se = FALSE, color = "red") +
  labs(x = "DMC",
       y = "Área quemada"
  ) +
  theme_bw()+
  facet_grid(.~ "Dispersión entre DMC y área quemada")


# Análisis bivariado num vs cat ----

# Agrupación por "month"
agrup_month <- df %>%
  group_by(month) %>%
  summarise(n = length(area_log),
            media = mean(area_log),
            ds = sd(area_log),
            mediana = median(area_log),
            minimo = min(area_log),
            maximo = max(area_log),
            Q1 = quantile(area_log, 0.25),
            Q3 = quantile(area_log, 0.75),
            IQR = IQR(area_log)) %>%
  mutate(variable = "month", niveles = as.character(month)) %>%
  select(variable, niveles, everything(), -month)
g1 <- df %>% 
  ggplot(aes(x = month, y = area_log)) +
  geom_boxplot(fill = "#87CEFA", outlier.colour = "red", outlier.shape = 16) +
  stat_summary(fun = mean, geom = "point", shape = 18, size = 3, color = "darkblue") +
  labs(x = "Mes del año", y = "Área quemada") +
  theme_bw() +
  facet_grid(.~"Distribución de área quemada por meses del año")

# Agrupación por "day"
agrup_day <- df %>%
  group_by(day) %>%
  summarise(n = length(area_log),
            media = mean(area_log),
            ds = sd(area_log),
            mediana = median(area_log),
            minimo = min(area_log),
            maximo = max(area_log),
            Q1 = quantile(area_log, 0.25),
            Q3 = quantile(area_log, 0.75),
            IQR = IQR(area_log)) %>%
  mutate(variable = "day", niveles = as.character(day)) %>%
  select(variable, niveles, everything(), -day)
g2 <- df %>% 
  ggplot(aes(x = day, y = area_log)) +
  geom_boxplot(fill = "#87CEFA", outlier.colour = "red", outlier.shape = 16) +
  stat_summary(fun = mean, geom = "point", shape = 18, size = 3, color = "darkblue") +
  labs(x = "Días de la semana", y = "Área quemada") +
  theme_bw() +
  facet_grid(.~"Distribución de área quemada por día de la semana")

# Unión de las dos tablas
bind_rows(agrup_month, agrup_day)
g1 / g2
