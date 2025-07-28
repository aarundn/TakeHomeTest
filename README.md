# 🧪 Take Home Test Application

A sample Android application built using **Kotlin** and **Jetpack Compose**, showcasing Clean Architecture and MVI pattern for fetching and displaying character data from the Rick and Morty API.

---

## 📋 Table of Contents
- [✨ Features](#-features)
- [🧱 Architecture](#-architecture)
- [🛠️ Technologies Used](#-technologies-used)
- [🚀 Build & Run Instructions](#-build--run-instructions)
- [🧠 Assumptions & Decisions](#-assumptions--decisions)

---

## ✨ Features
- 🔍 **Search Characters** by name
- 📄 **Character List** with pagination
- 📘 **Character Detail View**
- 🌙 **Dark/Light Theme** with Material 3

---

## 🧱 Architecture

The project follows **Clean Architecture** with a layered MVI structure:

### 🧩 Layer Overview

#### 1. Presentation Layer (Jetpack Compose + MVI)
- **UI**: Stateless Composables
- **ViewModel**: Handles `Intent`, emits `State`, and triggers `Events`
- **UI Models**: Presentation-specific data format

#### 2. Domain Layer
- **Use Cases**: Business rules (e.g., `GetCharactersUseCase`)
- **Repositories (Interfaces)**: Abstract contract
- **Domain Models**: Pure data classes

#### 3. Data Layer
- **Repositories (Implementations)**: Implements domain contracts
- **Data Sources**: Remote (Ktor)
- **DTOs / Mappers**: Convert API response to domain models

#### 4. DI Layer (Hilt)
- Provides dependencies to all layers via modules

### 🔄 Data Flow

```mermaid
graph TD
    A[Presentation Layer] --> B1[UI (Jetpack Compose)]
    A --> B2[ViewModel (MVI)]
    A --> B3[UI Models]

    B2 --> C[Domain Layer]
    C --> C1[Use Cases]
    C --> C2[Repository Interface]
    C2 --> D[Data Layer]

    D --> D1[Repository Implementation]
    D1 --> D2[Remote Data Source (Ktor)]
    D2 --> D3[DTOs / Mappers]

    E[Dependency Injection (Hilt)] --> B2
    E --> D1
```
        A1[UI (Jetpack Compose)] --> A2[Intent]
        A2 --> A3[ViewModel]
        A3 --> A4[State]
        A4 --> A1
        A3 --> A5[Event]
        A5 --> A1
    end

    subgraph Domain
        B1[Use Cases] --> B2[Repository Interface]
    end

    subgraph Data
        C1[Repository Implementation] --> C2[Remote Data Source]
        C2 --> C3[DTOs]
        C3 --> C4[Mappers]
        C4 --> C1
        C1 --> B2
    end

    subgraph DI
        D1[Hilt Modules] --> A3
        D1 --> C1
    end
```

---

## 🛠️ Technologies Used

| Technology            | Role                                |
|-----------------------|-------------------------------------|
| Kotlin                | Programming language                |
| Jetpack Compose       | UI framework                        |
| Ktor                  | API Client                          |
| Kotlinx Serialization | JSON serialization                  |
| Hilt (Dagger)         | Dependency Injection                |
| Coil                  | Image loading                       |
| Navigation Compose    | Navigation between screens          |
| Material 3            | Design system and theming           |
| Gradle Kotlin DSL     | Build system                        |

---

## 🚀 Build & Run Instructions

### 📦 Prerequisites
- Android Studio **Flamingo** or later
- Android SDK **35**
- JDK **11+**
- Gradle Plugin: `8.9.2`
- Kotlin: `2.0.21`

### ▶️ Steps

1. **Clone the repository**
   ```bash
   git clone <repository_url>
   cd TakeHomeTest
   ```

2. **Open in Android Studio**
    - Open the project and let Gradle sync.

3. **Build the project**
    - Click on `Build > Make Project`.

4. **Run the app**
    - Choose a device or emulator and click the green `Run` ▶️ button.

---

## 🧠 Assumptions & Decisions

- ✅ **No local database**: All data is fetched from the API directly.
- ✅ **Manual pagination**: Custom logic instead of Paging 3 for simplicity.
- ✅ **Simplified search**: API search only, no offline cache.
- ✅ **Hilt for DI**: Chosen for maintainability and minimal boilerplate.
- ✅ **Lightweight MVI**: Clean custom implementation over third-party libraries.

---