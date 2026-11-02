![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2-green)
![Spring AI](https://img.shields.io/badge/Spring_AI-Integrated-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)
# Smart Expense AI 💸🤖

An AI-powered expense management backend built with Java 17, Spring Boot 3, and Spring AI. This project demonstrates modern backend architecture, integrating LLM capabilities for document extraction and policy Q&A.

## 🏗️ Architecture Overview
- **Client** -> REST API (Spring Web)
- **Backend** -> Spring Boot 3 (Java 17)
- **AI Integration** -> Spring AI (Mocked LLM for demonstration)
- **Database** -> PostgreSQL (Planned for RAG Vector Store)

## ✨ Key Features
- [x] **AI Receipt Extraction (Mocked)**: Provides an API to simulate extracting merchant, date, and amount from a receipt image.
- [x] **RAG Policy Assistant (Mocked)**: Provides an API for natural language queries against corporate travel and expense policies.
- [x] **RESTful API Design**: Clean, well-documented APIs.
- [x] **Dockerized Deployment**: Easy setup with Dockerfile.

## 🛠️ Tech Stack
- **Core**: Java 17, Spring Boot 3.2.5
- **AI**: Spring AI (OpenAI API)
- **Testing**: JUnit 5, Mockito
- **DevOps**: Docker

## 🚀 How to Run

### Option 1: Run locally with Maven
1. Clone the repo: `git clone https://github.com/green-mango990115/smart-expense-ai.git`
2. Build the project: `mvn clean package`
3. Run the application: `java -jar target/smart-expense-ai-0.0.1-SNAPSHOT.jar`

### Option 2: Run with Docker
1. Build the Docker image: `docker build -t smart-expense-ai .`
2. Run the container: `docker run -p 8080:8080 smart-expense-ai`

## 🔌 API Endpoints

### 1. Extract Receipt Data (Mock)
- **URL**: `/api/expenses/extract`
- **Method**: `POST`
- **Param**: `imageUrl` (String)

### 2. Ask Policy Assistant (Mock)
- **URL**: `/api/expenses/chat`
- **Method**: `POST`
- **Param**: `question` (String)
