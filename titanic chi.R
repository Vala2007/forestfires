# Titanic

library(datasets)
df = Titanic
View(df)

tabla = xtabs(Freq ~ Class+Survived, data=df)

chisq.test(tabla)




























