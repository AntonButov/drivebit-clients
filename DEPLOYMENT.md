# Deployment Guide

This guide explains how to set up automatic deployment to Digital Ocean after merging pull requests.

## Prerequisites

1. **Digital Ocean Droplet** with:
   - Ubuntu/Debian server
   - Nginx or Apache web server
   - SSH access configured

2. **Domain name** (optional, can use IP address)

## GitHub Secrets Configuration

Go to your repository settings → Secrets and variables → Actions, and add these secrets:

### Required Secrets

- `SERVER_HOST` - Your Digital Ocean server IP address or domain
- `SERVER_USER` - SSH username (usually `root` or your user)
- `SERVER_SSH_KEY` - Private SSH key for server access

### Optional Secrets

- `SERVER_PORT` - SSH port (default: 22)
- `SERVER_DOMAIN` - Your domain name (e.g., `app.yourdomain.com`)

## SSH Key Setup

1. **Generate SSH key pair** (if you don't have one):
   ```bash
   ssh-keygen -t rsa -b 4096 -C "github-actions@yourdomain.com"
   ```

2. **Add public key to server**:
   ```bash
   ssh-copy-id -i ~/.ssh/id_rsa.pub user@your-server-ip
   ```

3. **Add private key to GitHub secrets**:
   - Copy the private key content: `cat ~/.ssh/id_rsa`
   - Add it as `SERVER_SSH_KEY` secret in GitHub

## Server Preparation

### Install Web Server

**For Nginx:**
```bash
sudo apt update
sudo apt install nginx
sudo systemctl enable nginx
sudo systemctl start nginx
```

**For Apache:**
```bash
sudo apt update
sudo apt install apache2
sudo systemctl enable apache2
sudo systemctl start apache2
```

### Create Web Directory
```bash
sudo mkdir -p /var/www/drivebit-clients
sudo chown -R $USER:$USER /var/www/drivebit-clients
```

## How It Works

1. **Trigger**: Deployment runs when:
   - A new release is published on GitHub
   - Release must be created manually or via automation
   - This ensures only stable, tested versions are deployed

2. **Build Process**:
   - Builds JS distribution: `./gradlew :composeApp:jsBrowserDistribution`
   - Creates production-ready web files

3. **Deployment Process**:
   - Creates backup of current deployment
   - Copies new files to `/var/www/drivebit-clients`
   - Configures web server (Nginx/Apache)
   - Sets proper permissions

4. **Web Server Configuration**:
   - Serves static files
   - Enables gzip compression
   - Sets up caching for static assets
   - Configures SPA routing (fallback to index.html)

## Creating Releases

### Manual Release Creation

1. **Go to GitHub Releases**:
   - Navigate to your repository on GitHub
   - Click "Releases" → "Create a new release"

2. **Fill Release Information**:
   - **Tag version**: e.g., `v1.0.0`, `v1.2.3`
   - **Release title**: e.g., "Version 1.0.0"
   - **Description**: Describe changes and new features
   - **Target**: Select the branch (usually `trunk`)

3. **Publish Release**:
   - Click "Publish release"
   - This will automatically trigger deployment

### Automated Release Creation

You can also create releases programmatically:

```bash
# Create a release using GitHub CLI
gh release create v1.0.0 --title "Version 1.0.0" --notes "Release notes here"

# Or using git tags
git tag v1.0.0
git push origin v1.0.0
```

## Manual Deployment

To deploy manually (bypassing release trigger):

```bash
# Build the project
./gradlew :composeApp:jsBrowserDistribution

# Copy files to server
scp -r composeApp/build/dist/js/productionExecutable/* user@server:/var/www/drivebit-clients/
```

## Troubleshooting

### Common Issues

1. **SSH Connection Failed**:
   - Check `SERVER_HOST` and `SERVER_USER` secrets
   - Verify SSH key is correct
   - Ensure server allows SSH connections

2. **Permission Denied**:
   - Check file permissions on server
   - Ensure web server user has access to files

3. **Web Server Not Serving Files**:
   - Check web server configuration
   - Verify files are in correct directory
   - Check web server logs

### Logs

Check GitHub Actions logs for detailed error information:
- Go to Actions tab in your repository
- Click on the failed deployment
- Review the logs for each step

## Security Notes

- Keep SSH keys secure
- Use non-root user when possible
- Regularly update server packages
- Consider using HTTPS with Let's Encrypt
- Monitor server logs for suspicious activity

