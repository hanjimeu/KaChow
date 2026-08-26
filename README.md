### **Anatomia Mecânica**

Um catálogo interativo de peças automotivas e industriais inspirado no universo de Relâmpago McQueen (Ka-Chow!).

---

### **Sobre o Projeto**

O Anatomia Mecânica é um aplicativo Android desenvolvido em Kotlin e Jetpack Compose com foco em gerenciamento de peças mecânicas e componentes industriais complexos.

O app combina um fluxo seguro de autenticação através do Firebase Authentication com um sistema dinâmico de CRUD mantido em memória local via StateFlow. Tudo isso com uma identidade visual temática baseada na estética do Relâmpago McQueen.

---

### **Funcionalidades**

• Cadastro de usuário (createUserWithEmailAndPassword)
• Login (signInWithEmailAndPassword)
• Recuperação de senha por e-mail (sendPasswordResetEmail)
• Logout
• Home com identidade visual de Relâmpago McQueen e atalhos por categoria
• Filtro de peças por categoria (Engrenagens, Motores, Turbinas e Peças Industriais)
• Cadastro e edição de peças via dialog customizado
• Exclusão de peças em tempo real
• Restauração de catálogo com peças padrão do tema
• Perfil com dados do usuário autenticado e sair

---

### **Tecnologias Utilizadas**

• Linguagem: Kotlin
• UI Toolkit: Jetpack Compose
• Navegação: Navigation Compose
• Arquitetura: MVVM (Model-View-ViewModel)
• Gerenciamento de Estado: StateFlow (MutableStateFlow / collectAsState)
• Autenticação: Firebase Authentication

---


### **Como Executar o Projeto**

 **Pré-requisitos**

• Android Studio instalado (versão Giraffe ou superior)
• JDK 17 ou superior configurado
• Dispositivo Android físico ou emulador (API 24+)

 **Passo a Passo**

1. Clone o repositório:
   git clone [https://github.com/hanjimeu/KaChow]
2. Abra o projeto:
   Abra o Android Studio, selecione Open e escolha a pasta do projeto clonado.
3. Configure o Firebase:
   Acesse o Console do Firebase ([https://console.firebase.google.com/](https://console.firebase.google.com/)).
   Crie um projeto e adicione um app Android com o pacote com.example.anatomiamecanica.
   Baixe o arquivo google-services.json e adicione na pasta app/ do seu projeto.
   No Firebase, ative o provedor de autenticação por E-mail/Senha.
4. Execute o aplicativo:
   Sincronize o Gradle (Sync Project with Gradle Files).
   Execute o app no emulador ou dispositivo físico (Shift + F10).

---

**Autor**

Desenvolvido por **Mariana dos Santos Moreira**.