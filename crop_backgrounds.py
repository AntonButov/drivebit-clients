#!/usr/bin/env python3
"""
Скрипт для обрезания фоновых изображений поиска
Убирает 30% сверху и снизу от каждого изображения
"""

import os
from PIL import Image
import glob

def crop_background_images():
    """Обрезает фоновые изображения поиска, убирая 30% сверху и снизу"""
    
    # Путь к папке с фоновыми изображениями
    backgrounds_dir = "images/searchbackground"
    
    if not os.path.exists(backgrounds_dir):
        print(f"Папка {backgrounds_dir} не найдена!")
        return
    
    # Находим все изображения в папке searchbackground
    image_extensions = ['*.jpg', '*.jpeg', '*.png', '*.webp']
    image_files = []
    
    for ext in image_extensions:
        image_files.extend(glob.glob(os.path.join(backgrounds_dir, ext)))
    
    if not image_files:
        print(f"Изображения в папке {backgrounds_dir} не найдены!")
        return
    
    print(f"Найдено {len(image_files)} фоновых изображений для обработки:")
    
    for image_path in image_files:
        try:
            # Открываем изображение
            with Image.open(image_path) as img:
                original_width, original_height = img.size
                print(f"Обрабатываем: {os.path.basename(image_path)} ({original_width}x{original_height})")
                
                # Вычисляем новые размеры (убираем 30% сверху и снизу)
                # Оставляем 40% от высоты (30% сверху + 30% снизу = 60% убираем)
                new_height = int(original_height * 0.4)
                
                # Вычисляем отступы
                top_crop = int(original_height * 0.3)  # 30% сверху
                bottom_crop = original_height - new_height - top_crop  # остальное снизу
                
                # Обрезаем изображение
                # left, top, right, bottom
                cropped_img = img.crop((0, top_crop, original_width, original_height - bottom_crop))
                
                # Сохраняем обрезанное изображение (перезаписываем оригинал)
                cropped_img.save(image_path, quality=85, optimize=True)
                
                new_width, final_height = cropped_img.size
                print(f"  Обрезано до: {new_width}x{final_height}")
                
                # Показываем экономию места
                original_size = os.path.getsize(image_path)
                print(f"  Размер файла: {original_size / 1024:.1f} KB")
                
        except Exception as e:
            print(f"Ошибка при обработке {image_path}: {e}")
    
    print("\nОбработка фоновых изображений завершена!")

if __name__ == "__main__":
    crop_background_images()
