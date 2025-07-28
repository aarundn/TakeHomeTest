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

### 🔄 Application Architecture Diagram

```mermaid
graph TD
    subgraph PresentationLayer[Presentation Layer (MVI)]
        UI["UI (Jetpack Compose)"]
        ViewModel[ViewModel]
        UIModels[UI Models]
    end

    subgraph DomainLayer[Domain Layer]
        UseCases[Use Cases]
        RepositoryInterfaces[Repository Interfaces]
        DomainModels[Domain Models]
    end

    subgraph DataLayer[Data Layer]
        RepositoryImplementations[Repository Implementations]
        DataSources[Remote/Local Data Source]
        DTOsMappers[DTOs / Mappers]
    end

    subgraph DILayer[Dependency Injection (Hilt)]
        HiltModules[Hilt Modules]
    end

    PresentationLayer --> DomainLayer
    DomainLayer --> DataLayer
    DILayer --> PresentationLayer
    DILayer --> DataLayer
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