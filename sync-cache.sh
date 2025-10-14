#!/bin/bash

# Script to sync build cache with GitHub Actions Cache (cloud)
# This provides cloud-based build cache sharing between local and CI

set -e

echo "☁️  Cloud Build Cache Manager"

# Check if GitHub CLI is installed
check_gh_cli() {
    if ! command -v gh &> /dev/null; then
        echo "❌ GitHub CLI not found. Please install it:"
        echo "   brew install gh  # macOS"
        echo "   sudo apt install gh  # Ubuntu"
        echo "   https://cli.github.com/"
        exit 1
    fi
}

# Check authentication
check_auth() {
    if ! gh auth status &> /dev/null; then
        echo "❌ Not authenticated with GitHub. Please run:"
        echo "   gh auth login"
        exit 1
    fi
}

# Function to upload cache to GitHub Actions cache
upload_cache() {
    echo "📤 Uploading cache to GitHub Actions Cache..."
    
    check_gh_cli
    check_auth
    
    # Create cache directory if it doesn't exist
    mkdir -p ~/.gradle/build-cache
    
    # Generate cache key based on current commit
    CACHE_KEY="gradle-build-cache-$(git rev-parse HEAD 2>/dev/null || echo 'local')"
    
    echo "🔑 Cache key: $CACHE_KEY"
    
    # Upload cache
    if gh cache upload --path ~/.gradle/build-cache --key "$CACHE_KEY"; then
        echo "✅ Cache uploaded successfully to GitHub Actions Cache"
    else
        echo "⚠️  Cache upload failed, but local cache is still available"
    fi
}

# Function to download cache from GitHub Actions
download_cache() {
    echo "📥 Downloading cache from GitHub Actions Cache..."
    
    check_gh_cli
    check_auth
    
    # Create cache directory if it doesn't exist
    mkdir -p ~/.gradle/build-cache
    
    # Try to download cache for current commit
    CACHE_KEY="gradle-build-cache-$(git rev-parse HEAD 2>/dev/null || echo 'local')"
    
    echo "🔑 Looking for cache key: $CACHE_KEY"
    
    # Download cache
    if gh cache download --key "$CACHE_KEY" --path ~/.gradle/build-cache; then
        echo "✅ Cache downloaded successfully from GitHub Actions Cache"
    else
        echo "ℹ️  No cache found for current commit, will use local cache"
    fi
}

# Function to clean cache
clean_cache() {
    echo "🧹 Cleaning build cache..."
    rm -rf ~/.gradle/build-cache/*
    echo "✅ Local cache cleaned"
}

# Function to show cache status
show_status() {
    echo "📊 Cache status:"
    if [ -d ~/.gradle/build-cache ]; then
        echo "   Local cache directory: ~/.gradle/build-cache"
        echo "   Local cache size: $(du -sh ~/.gradle/build-cache 2>/dev/null | cut -f1 || echo '0B')"
        echo "   Local cache files: $(find ~/.gradle/build-cache -type f 2>/dev/null | wc -l || echo '0')"
    else
        echo "   Local cache directory: Not found"
    fi
    
    # Check GitHub CLI status
    if command -v gh &> /dev/null; then
        if gh auth status &> /dev/null; then
            echo "   GitHub CLI: ✅ Authenticated"
        else
            echo "   GitHub CLI: ❌ Not authenticated"
        fi
    else
        echo "   GitHub CLI: ❌ Not installed"
    fi
}

# Function to setup GitHub token for Gradle
setup_token() {
    echo "🔑 Setting up GitHub token for Gradle..."
    
    check_gh_cli
    check_auth
    
    # Get GitHub token
    TOKEN=$(gh auth token)
    
    if [ -n "$TOKEN" ]; then
        echo "✅ GitHub token found"
        echo "💡 Add this to your shell profile (~/.zshrc or ~/.bashrc):"
        echo "   export GITHUB_TOKEN=\"$TOKEN\""
        echo "   export GITHUB_ACTOR=\"$(gh api user --jq .login)\""
        echo ""
        echo "🔄 Or run this command now:"
        echo "   export GITHUB_TOKEN=\"$TOKEN\""
        echo "   export GITHUB_ACTOR=\"$(gh api user --jq .login)\""
    else
        echo "❌ Could not get GitHub token"
    fi
}

# Main script logic
case "${1:-status}" in
    "upload")
        upload_cache
        ;;
    "download")
        download_cache
        ;;
    "clean")
        clean_cache
        ;;
    "setup")
        setup_token
        ;;
    "status"|*)
        show_status
        ;;
esac

echo ""
echo "🎯 Cloud Build Cache Manager complete!"
echo ""
echo "💡 Quick start:"
echo "   1. Run './sync-cache.sh setup' to configure GitHub token"
echo "   2. Run './sync-cache.sh download' to get CI cache"
echo "   3. Run './sync-cache.sh upload' before pushing to share cache"
echo "   4. Run './sync-cache.sh status' to check cache status"
