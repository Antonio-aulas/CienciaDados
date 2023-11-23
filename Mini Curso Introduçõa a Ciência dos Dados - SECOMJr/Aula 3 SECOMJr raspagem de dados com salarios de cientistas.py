# executar:
# pip install beautifulsoap4
# pip install selenium
# pip install
# pip install pandas
# pip install re
# pip install
# pip install numpy
# pip install webdriver-manager

from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from bs4 import BeautifulSoup
import pandas as pd
import re # importando expressões regulares para selecionar texto dentro de outro
import numpy as np
import matplotlib.pyplot as plt

option = webdriver.ChromeOptions()
driver = webdriver.Chrome(options = option)


url = "https://www.glassdoor.com.br/Sal%C3%A1rios/cientista-de-dados-sal%C3%A1rio-SRCH_KO0,18.htm"


driver.get(url)

# Agora você pode usar BeautifulSoup no conteúdo da página renderizada pelo navegador controlado pelo Selenium
sopa_bonita = BeautifulSoup(driver.page_source, 'html.parser')

#print(sopa_bonita)

lista_empresas = sopa_bonita.find_all('h3',{'data-test': re.compile('salaries-list-item-.*-employer-name')})
print(lista_empresas)
lista_salarios = sopa_bonita.find_all('div',{'data-test': re.compile('salaries-list-item-.*-salary-info')})
lista_todos_salarios=[]
 # zip não é zipar, é trabalhar com duas listas dentro do loop
for empresa, salario in zip(lista_empresas, lista_salarios):
    nome_empresa=empresa.find('a').text
    print(nome_empresa)
    str_salario = salario.contents[0].texto
    str_salario=salario.contents[0].text.replace('R$', '').replace('\xa0', '').replace('.','')
    lista_todos_salarios.append((nome_empresa,str_salario))
df_salarios=pd.DataFrame(lista_todos_salarios, columns=['empresa','salario'])
df_salarios['salario']=df_salarios['salario'].astype(np.float32)
print(df_salarios)


# Certifique-se de fechar o driver após usá-lo
driver.quit()
# Especifique o caminho do arquivo de destino
caminho_arquivo_excel = 'h:\salarios_cientista_dados.csv'

# Salve o DataFrame no arquivo do Excel
df_salarios.to_csv(caminho_arquivo_excel, index=False)

ax = df_salarios.plot(kind='bar', x='empresa', y='salario', legend=False)

# Adicionar rótulos aos eixos x e y
ax.set_xlabel("Empresa")
ax.set_ylabel("Salário")
plt.tight_layout()

# Exibir o gráfico
plt.show()

