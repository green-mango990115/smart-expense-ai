![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2-green)
![Spring AI](https://img.shields.io/badge/Spring_AI-Integrated-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)

# Smart Expense AI 💸🤖

An enterprise-grade, AI-powered expense management backend built with Java 17, Spring Boot 3, and Spring AI. This project demonstrates modern layered architecture, integrating real LLM capabilities (DeepSeek) for Travel & Expense (T&E) policy Q&A.

## 🏗️ Architecture Overview

This project follows a standard enterprise layered architecture:

*   **Controller Layer**: Handles incoming HTTP requests.
*   **Service Layer (Interface + Impl)**: Contains core business logic.
*   **AI Integration**: Uses Spring AI to connect with DeepSeek API.
*   **Exception Handling**: Global exception handler for standardized JSON responses.
*   **DTO**: Ensures clean, predictable API contracts.

## ✨ Key Features

*   [x] **Real LLM Policy Assistant**: Natural language queries powered by Spring AI and DeepSeek.
*   [x] **Layered Architecture**: Clean separation of Controller, Service, and DTO.
*   [x] **Global Exception Handling**: Graceful error recovery.
*   [x] **Dockerized Deployment**: Easy containerized setup.
*   [x] **AI Function Calling (Agent)**: Uses Spring AI `@Tool` annotations to allow the LLM to autonomously execute Java functions based on user intent.

## 🛠️ Tech Stack

*   **Core**: Java 17, Spring Boot 3.2.5
*   **AI**: Spring AI (DeepSeek API)
*   **Testing**: JUnit 5, Mockito
*   **DevOps**: Docker

## 📸 API Documentation (Swagger UI)

<img width="1912" height="948" alt="cd1ddfac2f7016ad852cb38632466fc6" src="https://github.com/user-attachments/assets/bb7c780d-bc19-43f1-a8f6-d145f292ecbd" />
Example of an AI agent autonomously calling multiple Java functions (Tools) to calculate exchange rates, check policy limits, and query approval status in one request.


## 🚀 How to Run

### Prerequisites
You need an API Key from DeepSeek (https://platform.deepseek.com/).

### Option 1: Run locally with Maven

1. Clone the repository.
2. Configure the API Key in `src/main/resources/application.properties`.
3. Build and run the application.

### Option 2: Run with Docker

1. Build the Docker image.
2. Run the container.

## 🔌 API Endpoints

### 1. Ask Policy Assistant (Real AI)

*   **URL**: `/api/expenses/chat`
*   **Method**: `POST`

**Body (JSON):**
{
"question": "Can I book a flight to Berlin for a business trip?"
}

**Response:**
{
"answer": "Yes. For business travel to Berlin...",
"status": "SUCCESS"
}

### 2. Extract Receipt Data (Simulated)

*   **URL**: `/api/expenses/extract`
*   **Method**: `POST`
*   **Param**: `imageUrl` (String)
