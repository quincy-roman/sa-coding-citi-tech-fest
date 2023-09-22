import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { HttpUploadProgressEvent } from '@angular/common/http';
import { DomSanitizer } from '@angular/platform-browser';

@Injectable({
  providedIn: 'root',
})
export class FileService {
  constructor(private api: ApiService, private sanitizer: DomSanitizer) {}

  /**
   * Handler for <input> file upload onChange event
   * @param event
   * @returns
   */
  onFileSelectedHandler = (event: Event): File | Blob => {
    const file = (event.target as any).files[0];
    return file ?? new Blob();
  };


  /**
   * generates the link to initiate file download for <a href="">
   * @param file
   * @returns
   */
  genFileHref = (file: File | Blob) => {
    const href = this.sanitizer.bypassSecurityTrustResourceUrl(
      window.URL.createObjectURL(file)
    );
    return href;
  };
}
