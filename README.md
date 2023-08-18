# Cocktail Bar 🍸 

# The app was created in *14 hours*

Cocktail Bar is an application that enables users to create and store their favorite cocktails in one place.

With this app, users can input details about each cocktail, such as its name, description, ingredient list, preparation recipe, and keep them saved on their device.

## Demonstration

### Screenshots

<img src="https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/d1087be1-976d-4d90-8eb4-1b593f8eb066" width="200">
<img src="https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/3e9ed722-afc7-40e0-bb37-0b076f1e525d" width="200">
<img src="https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/dbe43118-94dc-448e-9651-cd1fccbb6c9d" width="200">
<img src="https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/61459551-a7b3-4e8e-9516-f1bd553017f9" width="200">
<img src="https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/8092a846-87e0-4114-b98e-df8ba424b32f" width="200">
<img src="https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/d9ae0dd0-f556-416d-b0bd-345fa9263c9e" width="200">
<img src="https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/708e8d8c-c24a-4895-85c3-caec0f6fbf4d" width="200">


### Video

https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/4673fe87-758f-4028-8681-44dd30879f0a

https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/088e4f65-ba5e-4a72-996e-0190286d2ed5

https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/80439f3d-3aa5-4019-9458-bb9cd64335a0

https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/5bf8e600-c3e4-4fd5-bfbb-b74f35cbb9a8

https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/assets/84292117/f90dfaab-3a17-40f8-b12b-1c834e48b5b0

[Link to the latest video on Google Drive](https://drive.google.com/file/d/1sQXrhsvZzB-o7J-ldNoVVvm9rl3n2_kE/view?usp=sharing)




## Стек
* Kotlin
* Jetpack Compose
* MVVM
* Compose navigation
* Hilt
* Room
* Material/Material 3 elements

## What has been implemented

* **UI**: The entire application interface and navigation logic have been fully implemented. Specifically, all buttons lead to the required screens, mandatory field validation is in place, a fixed-size Bottom Sheet with scrollable content, and a container with a cutout for the FAB (Floating Action Button).
* **Functionality**: After the initial opening, a welcome screen is displayed. Pressing the + button opens a cocktail creation form. Upon saving, the main menu opens with the saved cocktail. **Upon subsequent app launches, the welcome screen is not displayed**, as the user has already saved cocktails.
* **Cocktail Creation**: From the main screen, pressing the FAB allows the creation of a new cocktail.
* **Cocktail Editing**: Pressing a cocktail in the main menu opens its description in a Bottom Sheet with an EDIT button. Clicking this button opens a cocktail editing form. Values entered in the form will overwrite the selected cocktail's parameters upon clicking the SAVE button.
* **Container for FAB**: A container with a cutout for the FAB has been implemented on the main menu screen, following the design.
* **Room Implementation**: All interfaces and settings for working with cocktails **and ingredients** have been fully implemented. Only their usage remains.

## What has not been implemented

* Cocktail creation logic works correctly. However, due to a highly non-obvious [Room behavior](https://stackoverflow.com/questions/44109700/how-to-make-primary-key-as-autoincrement-for-room-persistence-lib#:~:text=A%20note%20for%20future%20readers%20%2D%20the%20primary%20key%20must%20be%200%20for%20Room%20to%20treat%20it%20as%20unset.%20If%20you%20use%20any%20other%20default%20value%20(e.g.%20-1)%2C%20Room%20will%20not%20autogenerate%20the%20id.), entered values overwrite the existing cocktail when writing to the database. This has been fixed in the [after-shock](https://github.com/KovshefulCoder/Surf-Test-Task--School-2023/tree/after-shock) branch.
* Cocktail editing logic works correctly. However, the previous cocktail parameters are not transferred to the editing screen.
* There is no functionality in place for working with ingredients. Cocktails cannot be added with ingredients, and consequently, ingredients cannot be removed.

