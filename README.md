![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2-green)
![Spring AI](https://img.shields.io/badge/Spring_AI-Integrated-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)
# Smart Expense AI 💸🤖

An AI-powered expense management backend built with Java 17, Spring Boot 3, and Spring AI. This project demonstrates modern backend architecture, integrating LLM capabilities for document extraction and policy Q&A.

> ⚠️ **Note:** This repository is currently under active development. The core architecture and API designs are being implemented.

## 🏗️ Architecture Overview
*(Diagram coming soon)*
- **Client** -> REST API (Spring Web)
- **Backend** -> Spring Boot 3 (Java 17)
- **AI Integration** -> Spring AI (Mocked LLM for demonstration)
- **Database** -> PostgreSQL (Planned for RAG Vector Store)

## ✨ Planned Key Features
- [ ] **AI Receipt Extraction**: Upload a receipt image, and the system extracts merchant, date, amount, and itemized lines.
- [ ] **RAG Policy Assistant**: Uses Retrieval-Augmented Generation to allow users to query corporate travel & expense policies in natural language.
- [ ] **RESTful API Design**: Clean, well-documented APIs for creating and approving expenses.
- [ ] **Dockerized Deployment**: Easy setup with Docker Compose.

## 🛠️ Tech Stack
- **Core**: Java 17, Spring Boot 3
- **AI**: Spring AI (OpenAI API)
- **Database**: PostgreSQL
- **Testing**: JUnit 5, Mockito
- **DevOps**: Docker, Docker Compose

## 🚀 How to Run (Once implemented)
1. Clone the repo: `git clone https://github.com/green-mango990115/smart-expense-ai.git`
2. Run with Docker: `docker-compose up -d`
3. Access the API at: `http://localhost:8080/api/expenses`
