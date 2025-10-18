#!/usr/bin/env python3
"""
Универсальный скрипт для оптимизации изображений
- Обрезает изображения, убирая 30% сверху и снизу
- Сжимает изображения для веб-использования
- Поддерживает JPG, PNG, WebP
"""

import os
import sys
from PIL import Image
import glob

def optimize_images(directory, crop_percent=30, quality=85):
    """
    Оптимизирует изображения в указанной директории
    
    Args:
        directory: путь к папке с изображениями
        crop_percent: процент для обрезания сверху и снизу (по умолчанию 30%)
        quality: качество сжатия для JPG (по умолчанию 85)
    """
    
    if not os.path.exists(directory):
        print(f"Папка {directory} не найдена!")
        return
    
    # Находим все изображения
    image_extensions = ['*.jpg', '*.jpeg', '*.png', '*.webp']
    image_files = []
    
    for ext in image_extensions:
        image_files.extend(glob.glob(os.path.join(directory, ext)))
    
    if not image_files:
        print(f"Изображения в папке {directory} не найдены!")
        return
    
    print(f"Найдено {len(image_files)} изображений в {directory}")
    print(f"Обрезаем {crop_percent}% сверху и снизу, качество: {quality}")
    print("-" * 50)
    
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
                
                # Вычисляем новые размеры
                crop_ratio = crop_percent / 100.0
                new_height = int(original_height * (1 - 2 * crop_ratio))
                
                # Вычисляем отступы
                top_crop = int(original_height * crop_ratio)
                bottom_crop = original_height - new_height - top_crop
                
                # Обрезаем изображение
                cropped_img = img.crop((0, top_crop, original_width, original_height - bottom_crop))
                
                # Сохраняем с оптимизацией
                if image_path.lower().endswith(('.jpg', '.jpeg')):
                    cropped_img.save(image_path, 'JPEG', quality=quality, optimize=True)
                elif image_path.lower().endswith('.png'):
                    cropped_img.save(image_path, 'PNG', optimize=True)
                elif image_path.lower().endswith('.webp'):
                    cropped_img.save(image_path, 'WEBP', quality=quality, optimize=True)
                else:
                    cropped_img.save(image_path, quality=quality, optimize=True)
                
                new_width, final_height = cropped_img.size
                new_size = os.path.getsize(image_path)
                total_new_size += new_size
                
                print(f"  Обрезано до: {new_width}x{final_height} ({new_size / 1024:.1f} KB)")
                
                # Показываем экономию
                savings = ((original_size - new_size) / original_size) * 100
                print(f"  Экономия: {savings:.1f}%")
                print()
                
        except Exception as e:
            print(f"Ошибка при обработке {image_path}: {e}")
            print()
    
    # Итоговая статистика
    total_savings = ((total_original_size - total_new_size) / total_original_size) * 100
    print("=" * 50)
    print(f"ИТОГО:")
    print(f"Исходный размер: {total_original_size / 1024 / 1024:.1f} MB")
    print(f"Новый размер: {total_new_size / 1024 / 1024:.1f} MB")
    print(f"Общая экономия: {total_savings:.1f}% ({((total_original_size - total_new_size) / 1024 / 1024):.1f} MB)")

def main():
    """Главная функция"""
    if len(sys.argv) < 2:
        print("Использование: python3 optimize_images.py <путь_к_папке> [процент_обрезания] [качество]")
        print("Пример: python3 optimize_images.py images/cars 30 85")
        return
    
    directory = sys.argv[1]
    crop_percent = int(sys.argv[2]) if len(sys.argv) > 2 else 30
    quality = int(sys.argv[3]) if len(sys.argv) > 3 else 85
    
    optimize_images(directory, crop_percent, quality)

if __name__ == "__main__":
    main()
