#!/usr/bin/env python3
"""
Скрипт для обрезания фоновых изображений поиска по краям
Убирает 20% с каждой стороны (слева, справа, сверху, снизу)
"""

import os
from PIL import Image
import glob

def crop_background_images_edges():
    """Обрезает фоновые изображения поиска, убирая 20% с каждой стороны"""
    
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
    print("Обрезаем 20% с каждой стороны (слева, справа, сверху, снизу)")
    print("-" * 60)
    
    total_original_size = 0
    total_new_size = 0
    
    for image_path in image_files:
        try:
            # Открываем изображение
            with Image.open(image_path) as img:
                original_width, original_height = img.size
                original_size = os.path.getsize(image_path)
                total_original_size += original_size
                
                print(f"Обрабатываем: {os.path.basename(image_path)}")
                print(f"  Исходный размер: {original_width}x{original_height} ({original_size / 1024:.1f} KB)")
                
                # Вычисляем новые размеры (убираем 20% с каждой стороны)
                # Оставляем 60% от ширины и высоты (20% слева + 20% справа = 40% убираем)
                new_width = int(original_width * 0.6)
                new_height = int(original_height * 0.6)
                
                # Вычисляем отступы
                left_crop = int(original_width * 0.2)    # 20% слева
                top_crop = int(original_height * 0.2)    # 20% сверху
                right_crop = original_width - new_width - left_crop   # остальное справа
                bottom_crop = original_height - new_height - top_crop # остальное снизу
                
                # Обрезаем изображение
                # left, top, right, bottom
                cropped_img = img.crop((left_crop, top_crop, original_width - right_crop, original_height - bottom_crop))
                
                # Сохраняем обрезанное изображение (перезаписываем оригинал)
                cropped_img.save(image_path, quality=85, optimize=True)
                
                final_width, final_height = cropped_img.size
                new_size = os.path.getsize(image_path)
                total_new_size += new_size
                
                print(f"  Обрезано до: {final_width}x{final_height} ({new_size / 1024:.1f} KB)")
                
                # Показываем экономию места
                savings = ((original_size - new_size) / original_size) * 100
                print(f"  Экономия: {savings:.1f}%")
                print()
                
        except Exception as e:
            print(f"Ошибка при обработке {image_path}: {e}")
            print()
    
    # Итоговая статистика
    total_savings = ((total_original_size - total_new_size) / total_original_size) * 100
    print("=" * 60)
    print(f"ИТОГО:")
    print(f"Исходный размер: {total_original_size / 1024 / 1024:.1f} MB")
    print(f"Новый размер: {total_new_size / 1024 / 1024:.1f} MB")
    print(f"Общая экономия: {total_savings:.1f}% ({((total_original_size - total_new_size) / 1024 / 1024):.1f} MB)")

if __name__ == "__main__":
    crop_background_images_edges()
